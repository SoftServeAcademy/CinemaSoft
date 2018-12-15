package softServe.academy.cinemasoft.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import softServe.academy.cinemasoft.model.Auditorium;
import softServe.academy.cinemasoft.model.Screening;
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

    @Autowired
    public ScreeningController(ScreeningService screeningService, AuditoriumService auditoriumService){
        this.screeningService = screeningService;
        this.auditoriumService = auditoriumService;
    }

    //ADD
    @GetMapping(value = "/addScreening")
    public String addScreening(Model model){
        model.addAttribute("screening", new Screening());
        model.addAttribute("auditoriums", this.auditoriumService.findAll());
        return "add-screening";
    }

    //ADD
    @PostMapping("/addScreening")
    public String createScreening(@ModelAttribute("screening") Screening screening){
        screeningService.createScreening(screening);
        return "redirect:/listScreening";
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
        return mav;
    }

    @PostMapping(value = "/editScreening/{id}")
    public String postEditScreening(@ModelAttribute("screening") Screening screening,@PathVariable("id") int Id){
        screeningService.editPostScreening(screening);
        return "redirect:/listScreening";
    }

    //LIST SCREENING
    @GetMapping(value = "/listScreening")
    public ModelAndView listScreening(Model model){
        ModelAndView modelAndView = new ModelAndView("list-screening");
        modelAndView.addObject("screening", screeningService.findAllScreenings());
        return modelAndView;
    }

}
