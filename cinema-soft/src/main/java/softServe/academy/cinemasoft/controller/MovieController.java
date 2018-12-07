package softServe.academy.cinemasoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import softServe.academy.cinemasoft.model.Movie;
import softServe.academy.cinemasoft.repository.CategoryRepository;
import softServe.academy.cinemasoft.service.MovieService;

@Controller
public class MovieController {
	

	@Autowired
    private MovieService movieService;

    @Autowired
    private CategoryRepository categoryRepository;
    
	@GetMapping("/add-movie")
    public String addMovie(Model model) {
       // modelAndView.setViewName("add-movie");
       // return modelAndView;
        model.addAttribute("movie", new Movie());
        return "add-movie";
    }

    @PostMapping("/add-movie")
    public String addMovieFromView(@ModelAttribute("movie") Movie movie, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                System.out.println(error);
            }
        }
        movieService.addMovie(movie);
        return "redirect:/add-movie";
    }
    
    @GetMapping("edit/{id}")
    public ModelAndView editMovie(ModelAndView modelAndView, @PathVariable int id) {
        modelAndView.setViewName("add-movie");
        Movie movie = movieService.findMovie(id);	        
        modelAndView.addObject("model", movie);
        return modelAndView;
    }
    
    @GetMapping("/show")
    public ModelAndView showMovie(ModelAndView modelAndView) {
        modelAndView.setViewName("index");
        List<Movie> allMovies = this.movieService.getAllMovie();
        modelAndView.addObject("movies", allMovies);
        return modelAndView;
    }
}

