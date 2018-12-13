package softServe.academy.cinemasoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import softServe.academy.cinemasoft.model.Movie;
import softServe.academy.cinemasoft.service.CategoryService;
import softServe.academy.cinemasoft.service.MovieService;

@Controller
public class MovieController {
	


	private final MovieService movieService;

	private final CategoryService categoryService;

    @Autowired
    public MovieController(MovieService movieService, CategoryService categoryService) {
        this.movieService = movieService;
        this.categoryService = categoryService;
    }

    @GetMapping("/add-movie")
    public String addMovie(Model model) {
        model.addAttribute("movie", new Movie());
        model.addAttribute("categories",this.categoryService.findAll());
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
    public String editMovie(@PathVariable int id, Model model) {
    	Movie movie = movieService.findMovie(id);
    	model.addAttribute("movie", movieService.editMovie(movie));
        model.addAttribute("categories",this.categoryService.findAll());
    	
        return "edit-movie";
    }
   
	@PostMapping("/edit-movie/{id}")
	public String editMovie(@PathVariable int id, @ModelAttribute("movie") Movie movie, BindingResult bindingResult) {		
	if (bindingResult.hasErrors()) {
		for (ObjectError error : bindingResult.getAllErrors()) {
               System.out.println(error);
          }
			return "redirect:/edit-movie";
		}
		movieService.editPostMovie(movie);

		return "redirect:/movie/"+movie.getId();
	}
   
	
	@DeleteMapping("/delete-movie/{id}")
	public String deleteMovie(@PathVariable int id) {
		movieService.deleteMovie(id);
		return "redirect:/";
	}  
    
    @GetMapping("/movie")
    public ModelAndView showMovie(ModelAndView modelAndView) {
        modelAndView.setViewName("index");
        List<Movie> allMovies = this.movieService.getAllMovie();
        modelAndView.addObject("movies", allMovies);
        return modelAndView;
    }
}

