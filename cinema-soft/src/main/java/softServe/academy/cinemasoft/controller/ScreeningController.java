package softServe.academy.cinemasoft.controller;

import org.springframework.http.HttpMethod;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import softServe.academy.cinemasoft.model.Screening;
import softServe.academy.cinemasoft.service.ScreeningService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static com.sun.deploy.trace.Trace.flush;
import static org.springframework.transaction.support.TransactionSynchronizationManager.clear;

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
   @PostMapping("/screening/add/{id}")
   public ResponseEntity<?> createScreening(@RequestBody Screening screening){
        screeningService.createScreening(screening);
        return ResponseEntity.status(HttpStatus.CREATED).build();
   }

    //GET ALL
    @GetMapping("/screening")
    public ResponseEntity<List<Screening>> getAllScreenings(){
        return ResponseEntity.ok(this.screeningService.findAllScreenings());
    }

    //DELETE
    @DeleteMapping(value ="/screening/remove/{id}")
    public String deleteScreening(@PathVariable("id") int Id){
        screeningService.deleteScreening(Id);
        return "redirect:/screening";
    }

    //EDIT
    @GetMapping(value = "/screening/edit")
    public ModelAndView editScreening(@PathVariable("id") int Id){
        Screening ss = screeningService.getScreeningById(Id);
        ModelAndView mav = new ModelAndView("editScreening");
        mav.addObject("screening", ss);
        return mav;
    }

    @PostMapping(value = "/screening/edit", params = {"startHour"})
    public String postEditScreening(@ModelAttribute("screening") Screening screening){
            String st = screening.getStartTime();
            int id = screening.getId();
            screeningService.editScreening(id, st);
        return "redirect:/screening";
    }

}
