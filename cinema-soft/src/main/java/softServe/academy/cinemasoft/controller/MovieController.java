package softServe.academy.cinemasoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;

import softServe.academy.cinemasoft.model.Movie;
import softServe.academy.cinemasoft.service.MovieService;

@Controller
public class MovieController {
	

	@Autowired
    private MovieService movieService;
    
	@GetMapping("/add-movie")
    public String addMovie(Model model) {
        model.addAttribute("movie", new Movie());
        return "add-movie";
    }

    @PostMapping("/add-movie")
    public String addMovieFromView(@ModelAttribute("movie") Movie movie, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                System.out.println(error);
            }
            return "redirect:/add-movie";
        }
        movieService.addMovie(movie);
        return "redirect:/movie";
    }
    
    @GetMapping("/edit-movie/{id}")
    public String editMovie(@PathVariable  Integer id) {
        movieService.editMovie(id);
        return "redirect:/edit-movie";
    }
    
	@PutMapping("/edit-movie/{id}")
	public String editMovie(BindingResult bindingResult, ModelMap model, @PathVariable  Integer id) {
		
		Movie urlMovie = movieService.findMovie(id);

		System.out.println(urlMovie);
		if (bindingResult.hasErrors()) {
			for (ObjectError error : bindingResult.getAllErrors()) {
                System.out.println(error);
            }
			return "redirect:/edit-movie";
		}

		movieService.editMovie(id);

		return "redirect:/movie";
	}
	
	@DeleteMapping("/delete-movie/{id}")
	public String deleteMovie(@PathVariable Integer id) {
		movieService.deleteMovie(id);

		return "redirect:/index";
	}
   
  
   
    
    @GetMapping("/movie")
    public ModelAndView showMovie(ModelAndView modelAndView) {
        modelAndView.setViewName("index");
        List<Movie> allMovies = this.movieService.getAllMovie();
        modelAndView.addObject("movies", allMovies);
        return modelAndView;
    }
}

