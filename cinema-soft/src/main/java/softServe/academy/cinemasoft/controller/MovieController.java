package softServe.academy.cinemasoft.controller;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import softServe.academy.cinemasoft.model.Movie;
import softServe.academy.cinemasoft.service.CategoryService;
import softServe.academy.cinemasoft.service.MovieService;

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

import java.io.IOException;
import java.util.Base64;


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
        model.addAttribute("categories", this.categoryService.findAll());
        MultipartFile file = null;
        model.addAttribute("imageFile", file);

        return "add-movie";
    }

    @PostMapping("/add-movie")
    public String addMovieFromView(@ModelAttribute("movie") Movie movie, BindingResult bindingResult,@ModelAttribute("fileImage") MultipartFile imageFile) throws IOException {
        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                System.out.println(error);
            }
            return "redirect:/add-movie";
        }
        System.out.println(Base64.getEncoder().encodeToString(imageFile.getBytes()));
        byte[] cover = imageFile.getBytes();
        movie.setCover(cover);
      //  System.out.println(Base64.getEncoder().encodeToString(movie.getCover()));
        movieService.addMovie(movie);

        return "redirect:/";
    }

    @GetMapping("/edit-movie/{id}")
    public String editMovie(@PathVariable int id, Model model) {
        Movie movie = movieService.findMovie(id);

        model.addAttribute("movie", movieService.editMovie(movie));
        model.addAttribute("categories", this.categoryService.findAll());
        MultipartFile file = null;
        model.addAttribute("imageFile", file);

        return "edit-movie";
    }

    @PostMapping("/edit-movie/{id}")
    public String editMovie(@PathVariable int id, @ModelAttribute("movie") Movie movie, BindingResult bindingResult,Model model,@ModelAttribute("fileImage") MultipartFile imageFile) throws IOException {
        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                System.out.println(error);
            }
            return "redirect:/edit-movie";
        }

        byte[] cover = imageFile.getBytes();
        movie.setCover(cover);
        movieService.editPostMovie(movie);

       // String image = Base64.getEncoder().encodeToString(movieService.getMovieById(id).getCover());
       // model.addAttribute("image",image);
        return "redirect:/movie/" + movie.getId();
    }

    @DeleteMapping("/delete-movie/{id}")
    public String deleteMovie(@PathVariable int id) {
        movieService.deleteMovie(id);

        return "redirect:/";
    }

}