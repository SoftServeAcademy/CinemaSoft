package softServe.academy.cinemasoft.controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import softServe.academy.cinemasoft.model.Screening;
import softServe.academy.cinemasoft.service.ScreeningService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;


@Controller
public class ScreeningController {

    private ScreeningService screeningService;

    @Autowired
    public ScreeningController(ScreeningService screeningService){
        this.screeningService = screeningService;
    }

    //GET BY ID
    @GetMapping("/screening/{id}")
    public ResponseEntity<?> getScreeningById(@PathVariable int id){
        Screening result = this.screeningService.getScreeningById(id);
        if (result != null){
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //ADD
    @GetMapping(value = "/addScreening")
    public String addScreening(Model model){
        model.addAttribute("screening", new Screening());
        return "add-screening";
    }

    //ADD
    @PostMapping("/addScreening")
    public String createScreening(@ModelAttribute("screening") Screening screening, BindingResult bindingResult){
        screeningService.createScreening(screening);
        return "redirect:/screening";
    }


    //GET ALL
    @GetMapping("/screening")
    public ResponseEntity<List<Screening>> getAllScreenings(){
        return ResponseEntity.ok(this.screeningService.findAllScreenings());
    }

    //DELETE
    @DeleteMapping(value ="/removeScreening/{id}")
    public String deleteScreening(@PathVariable("id") int Id){
        screeningService.deleteScreening(Id);
        return "redirect:/screening";
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
        return "redirect:/screening";
    }

}
