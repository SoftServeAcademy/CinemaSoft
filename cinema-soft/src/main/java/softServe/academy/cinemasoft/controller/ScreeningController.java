package softServe.academy.cinemasoft.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import softServe.academy.cinemasoft.model.Screening;
import softServe.academy.cinemasoft.service.ScreeningService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
public class ScreeningController {

    private ScreeningService screeningService;

    @Autowired
    public ScreeningController(ScreeningService screeningService){
        this.screeningService = screeningService;
    }

    //ADD
    @GetMapping(value = "/addScreening")
    public String addScreening(Model model){
        model.addAttribute("screening", new Screening());
        return "add-screening";
    }

    //ADD
    @PostMapping("/addScreening")
    public String createScreening(@ModelAttribute("screening") Screening screening){
        screeningService.createScreening(screening);
        return "redirect:/listScreening";
    }

    //DELETE
    @DeleteMapping(value ="/removeScreening/{id}")
    public String deleteScreening(@PathVariable("id") int id){
        screeningService.deleteScreening(id);
        return "redirect:/listScreening";
    }

    //EDIT
    @GetMapping(value = "/editScreening/{id}")
    public ModelAndView editScreening(@PathVariable("id") int id){
        Screening ss = screeningService.getScreeningById(id);
        ModelAndView mav = new ModelAndView("edit-screening");
        mav.addObject("screening", ss);
        return mav;
    }

    @PostMapping(value = "/editScreening/{id}")
    public String postEditScreening(@ModelAttribute("screening") Screening screening,@PathVariable("id") int Id){
        String st = screening.getStartTime();
        screeningService.editScreening(Id, st);
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
