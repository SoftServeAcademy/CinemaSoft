package softServe.academy.cinemasoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import softServe.academy.cinemasoft.model.MovieSchedule;
import softServe.academy.cinemasoft.service.MovieScheduleService;

import java.util.List;

@Controller
public class MovieScheduleController {

    @Autowired
    private MovieScheduleService movieScheduleService;

    @Autowired
    public MovieScheduleController(MovieScheduleService movieScheduleService){
        this.movieScheduleService = movieScheduleService;
    }

    @PostMapping("/movieSchedule")
    @ResponseBody
    public ResponseEntity<?> createScheduledScreening(@RequestBody MovieSchedule movieSchedule){
        movieScheduleService.createMovieSchedule(movieSchedule);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/movieSchedule/{id}")
    @ResponseBody
    public ResponseEntity<?> getBookById(@PathVariable Integer id){
        MovieSchedule result = movieScheduleService.getMovieScheduleById(id);
        if (result !=null){
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/movieSchedules")
    @ResponseBody
    public ResponseEntity<List<MovieSchedule>> findAllBooks(){
        return ResponseEntity.ok(movieScheduleService.findAll());
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/program")
    public String program() {
        return "program";
    }

    @GetMapping("/movieSchedule")
    public ModelAndView getMovieSchedule(Model model) {
        ModelAndView modelAndView = new ModelAndView("index");
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
        return  "redirect:/movieSchedule";
    }

    @DeleteMapping("/editMovieSchedule")
    public String deleteMovieScheduleView(@ModelAttribute("movieSchedule") MovieSchedule movieSchedule) {
        movieScheduleService.deleteMovieSchedule(movieSchedule);
        return  "redirect:/movieSchedule";
    }

}
