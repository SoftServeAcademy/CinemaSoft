package softServe.academy.cinemasoft.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import softServe.academy.cinemasoft.model.Auditorium;
import softServe.academy.cinemasoft.model.Movie;
import softServe.academy.cinemasoft.model.Screening;
import softServe.academy.cinemasoft.service.MovieService;
import softServe.academy.cinemasoft.service.ScreeningService;
import softServe.academy.cinemasoft.service.AuditoriumService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;


@Controller
public class ScreeningController {

    private ScreeningService screeningService;
    private AuditoriumService auditoriumService;
    private MovieService movieService;

    @Autowired
    public ScreeningController(ScreeningService screeningService, AuditoriumService auditoriumService, MovieService movieService){
        this.screeningService = screeningService;
        this.auditoriumService = auditoriumService;
        this.movieService = movieService;
    }

    //ADD
    @GetMapping(value = "/addScreening")
    public String addScreening(Model model){
        model.addAttribute("screening", new Screening());
        model.addAttribute("auditoriums", this.auditoriumService.findAll());
        model.addAttribute("movie", this.movieService.getAllMovie());
        return "add-screening";
    }

    //ADD
    @PostMapping("/addScreening")
    public String createScreening(@ModelAttribute("screening") Screening screening){
        //screening validation
        String string = screening.getStartTime();
        if (screeningService.isValid(string)){
            screeningService.createScreening(screening);
            return "redirect:/listScreening";
        }
        return "redirect:/addScreening";
    }

    //DELETE
    @GetMapping(value ="/removeScreening/{id}")
    public String deleteScreening(@PathVariable("id") int id){
        screeningService.deleteScreening(id);
        return "redirect:/listScreening";
    }

    //EDIT
    @GetMapping(value = "/editScreening/{id}")
    public ModelAndView editScreening(@PathVariable("id") int id, Screening screening){
       // screening = screeningService.getScreeningById(id);
        ModelAndView mav = new ModelAndView("edit-screening");
        mav.addObject("screening", screening);
        mav.addObject("auditorium", this.auditoriumService.findAll());
        mav.addObject("movie", this.movieService.getAllMovie());
        return mav;
    }

    @PostMapping(value = "/editScreening/{id}")
    public String postEditScreening(@ModelAttribute("screening") Screening screening,
                                    @ModelAttribute("auditorium") Auditorium auditorium,
                                    @ModelAttribute("movie") Movie movie,
                                    @PathVariable("id") int Id){
        screeningService.editPostScreening(screening);
        auditoriumService.addAuditorium(auditorium);
        movieService.editMovie(movie);

        return "redirect:/listScreening";
    }

    //LIST SCREENING
    @GetMapping(value = "/listScreening")
    public ModelAndView listScreening(Model model){
        ModelAndView modelAndView = new ModelAndView("list-screening");
        modelAndView.addObject("screening", screeningService.findAllScreenings());
        modelAndView.addObject("movie", this.movieService.getAllMovie());
        modelAndView.addObject("auditorium", this.auditoriumService.findAll());
        return modelAndView;
    }

}
