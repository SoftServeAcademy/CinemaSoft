package softserve.academy.cinemasoft.controller;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import softserve.academy.cinemasoft.dto.MovieDirectorDTO;
import softserve.academy.cinemasoft.dto.MovieRatingDTO;
import softserve.academy.cinemasoft.model.Comment;
import softserve.academy.cinemasoft.model.Movie;
import softserve.academy.cinemasoft.repository.CommentRepository;
import softserve.academy.cinemasoft.service.CategoryService;
import softserve.academy.cinemasoft.service.CommentService;
import softserve.academy.cinemasoft.service.MovieService;
import softserve.academy.cinemasoft.utils.ObjectMapperUtils;

import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Controller
@Slf4j
public class MovieController {
    private final MovieService movieService;
    private CategoryService categoryService;
    private CommentService commentService;

    @Autowired
    public MovieController(MovieService movieService, CategoryService categoryService, CommentService commentService) {
        this.movieService = movieService;
        this.categoryService = categoryService;
        this.commentService = commentService;

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
    public String addMovieFromView(@Valid @ModelAttribute("movie") Movie movie, BindingResult bindingResult, @ModelAttribute("fileImage") MultipartFile imageFile,
                                   Model model) throws IOException {

        if (bindingResult.hasErrors()) {
            model.addAttribute("categories", this.categoryService.findAll());
            MultipartFile file = null;
            model.addAttribute("imageFile", file);
            return "add-movie";
        }
        byte[] cover = imageFile.getBytes();
        movie.setCover(cover);
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
    public String editMovie(@PathVariable int id, @ModelAttribute("movie") Movie movie, BindingResult bindingResult, Model model, @ModelAttribute("fileImage") MultipartFile imageFile) throws IOException {
        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                log.debug("Printing errors" + error);
            }
            return "redirect:/edit-movie";
        }
        if (imageFile.isEmpty()) {
            movie.setCover(movieService.getMovieById(id).getCover());
        } else {
            byte[] cover = imageFile.getBytes();
            movie.setCover(cover);
        }
        movieService.editPostMovie(movie);

        return "redirect:/movie/" + movie.getId();
    }

    @DeleteMapping("/delete-movie/{id}")
    public String deleteMovie(@PathVariable int id) {
        movieService.deleteMovie(id);

        return "redirect:/";
    }

    @GetMapping(value = "/movie/{id}")
    public ModelAndView showMovieById(@PathVariable("id") int id, Model model) {
        ModelAndView modelAndView = new ModelAndView("movie");
        modelAndView.addObject("selectMovie", movieService.getMovieById(id));
        model.addAttribute("comment", new Comment());
        model.addAttribute("comments", commentService.findByMovie(movieService.getMovieById(id)));
        model.addAttribute("screenings", movieService.getMovieById(id).getScreenings());
        String image = Base64.getEncoder().encodeToString(movieService.getMovieById(id).getCover());
        model.addAttribute("image", image);
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/searchByDirectorName/{name}")
    public List<MovieDirectorDTO> movies(@PathVariable("name") String name) {
        List<Movie> movies = this.movieService.searchMoviesByDirectorName(name);

        return ObjectMapperUtils.mapAll(movies, MovieDirectorDTO.class);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/ratingGreaterOrEqualThan/{value}")
    public List<MovieRatingDTO> getMoviesWithRatingGreaterOrEqualThan(@PathVariable("value") Double value) {
        List<Movie> movies = this.movieService.getMoviesWithRatingGreaterOrEqualThan(value);

        return ObjectMapperUtils.mapAll(movies, MovieRatingDTO.class);
    }

}