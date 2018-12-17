package softserve.academy.cinemasoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import softserve.academy.cinemasoft.model.MovieSchedule;
import softserve.academy.cinemasoft.service.MovieScheduleService;


@Controller
public class MovieScheduleController {

    private MovieScheduleService movieScheduleService;

    @Autowired
    public MovieScheduleController(MovieScheduleService movieScheduleService){
        this.movieScheduleService = movieScheduleService;
    }

    @GetMapping("/program")
    public ModelAndView getMovieSchedule(Model model) {
        ModelAndView modelAndView = new ModelAndView("program");
        modelAndView.addObject("movieSchedules", movieScheduleService.findAll());
        return modelAndView;
    }

    @GetMapping("/addMovieSchedule")
    public String addMovieScheduleView(Model model){
        model.addAttribute("movieSchedule", new MovieSchedule());
        return "addMovieSchedule";
    }

    @PostMapping("/addMovieSchedule")
    public String addMovieScheduleFromView(@ModelAttribute("movieSchedule") MovieSchedule movieSchedule, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            for(ObjectError error: bindingResult.getAllErrors()){
                System.out.println(error);
            }
        }
        movieScheduleService.createMovieSchedule(movieSchedule);
        return  "redirect:/program";
    }

    @DeleteMapping("/removeMovieSchedule/{id}")
    public String deleteMovieScheduleById(@PathVariable("id") int id){
        movieScheduleService.deleteMovieScheduleById(id);
        return "redirect:/program";
    }

    //Edit Movie Schedule
    @GetMapping("/editMovieSchedule/{id}")
    public ModelAndView editMovieSchedule(@PathVariable("id") int id, MovieSchedule movieSchedule) {
        ModelAndView editMS = new ModelAndView("editMovieSchedule");
        MovieSchedule temp = movieScheduleService.findById(id);
        editMS.addObject("movieSchedule", temp);
        return editMS;
    }
    @PostMapping("/editMovieSchedule/{id}")
    public String editMovieSchedule(@ModelAttribute("movieSchedule") MovieSchedule movieSchedule, @PathVariable("id") int Id) {
        movieScheduleService.editMovieSchedule(movieSchedule);
        return "redirect:/program";
    }
}
