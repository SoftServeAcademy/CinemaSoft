package softServe.academy.cinemasoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import softServe.academy.cinemasoft.model.entities.Movie;
import softServe.academy.cinemasoft.service.MovieService;

@Controller
@RequestMapping("/movies")
public class MovieController {
	
	Movie mockDataMovie = new Movie("111", "aaaaaaaaa", "bbbbbbbb", "ssssss", "ffffffff", "vvvvvvvv", 12.5);
	
	@Autowired
	 private MovieService movieService;
    
	@GetMapping("/add")
    public ModelAndView addMovie(ModelAndView modelAndView) {
        modelAndView.setViewName("add-movie");
        modelAndView.addObject("model", mockDataMovie);
        return modelAndView;
    }
	
	
	  
    @PostMapping("/add")
    public ModelAndView add(ModelAndView modelAndView, @RequestBody Movie movie) {
        modelAndView.setViewName("add-movie");
       
        modelAndView.addObject("model", this.movieService.addMovie(movie));
        return modelAndView;
    }
    
    @GetMapping("edit/{id}")
    public ModelAndView editMovie(ModelAndView modelAndView, @PathVariable String id) {
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

