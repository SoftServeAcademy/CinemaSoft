package softServe.academy.cinemasoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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

    private MovieScheduleService movieScheduleService;

    @Autowired
    public MovieScheduleController(MovieScheduleService movieScheduleService){
        this.movieScheduleService = movieScheduleService;
    }

    @GetMapping("/program")
    public String program() {
        return "program";
    }

    @PostMapping("/movieSchedule")
    @ResponseBody
    public ResponseEntity<?> createMovieSchedule(@RequestBody MovieSchedule movieSchedule){
        movieScheduleService.createMovieSchedule(movieSchedule);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/movieSchedule/{id}")
    @ResponseBody
    public ResponseEntity<?> getMovieScheduleById(@PathVariable Integer id){
        MovieSchedule result = movieScheduleService.getMovieScheduleById(id);
        if (result !=null){
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/movieSchedules")
    @ResponseBody
    public ResponseEntity<List<MovieSchedule>> findAllMovieSchedules(){
        return ResponseEntity.ok(movieScheduleService.findAll());
    }

    @GetMapping("/movieSchedule")
    public ModelAndView getMovieSchedule(Model model) {
        ModelAndView modelAndView = new ModelAndView("program");
//        modelAndView.addObject("movieSchedules", movieScheduleService.findAll(new Sort(Sort.Direction.DESC, "hours"));
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

    @DeleteMapping("/deleteMovieSchedule")
    public String deleteMovieScheduleView(@ModelAttribute("movieSchedule") MovieSchedule movieSchedule) {
        movieScheduleService.deleteMovieSchedule(movieSchedule);
        return  "redirect:/movieSchedule";
    }

//    //EDIT
//    @GetMapping("/editMovieSchedule/{id}")
//    public ModelAndView editMovieSchedule(@PathVariable("id") int id, MovieSchedule movieSchedule){
////        movieSchedule = movieScheduleService.getMovieScheduleById(id);
//        ModelAndView mav = new ModelAndView("editMovieSchedule");
//        mav.addObject("movieSchedule", movieSchedule);
//        return mav;
//    }
//
//    @PostMapping("/editMovieSchedule/{id}")
//    public String postEditMovieSchedule(@ModelAttribute("movieSchedule") MovieSchedule movieSchedule,@PathVariable("id") int Id){
//        movieScheduleService.editMovieSchedule(movieSchedule);
//        return "redirect:/listMovieSchedule";
//    }

    @DeleteMapping("/removeMovieSchedule/{id}")
    public String deleteMovieScheduleById(@PathVariable("id") int id){
        movieScheduleService.deleteMovieScheduleById(id);
        return "redirect:/movieSchedule";
    }

//    //List Movie Schedule
//    @GetMapping(value = "/listMovieSchedule")
//    public ModelAndView listMovieSchedule(Model model){
//        ModelAndView modelAndView = new ModelAndView("listMovieSchedule");
//        modelAndView.addObject("movieSchedule", movieScheduleService.findAll());
//        return modelAndView;
//    }

}
