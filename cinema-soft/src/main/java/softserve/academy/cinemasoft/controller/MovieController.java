package softserve.academy.cinemasoft.controller;

import lombok.extern.slf4j.Slf4j;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import softserve.academy.cinemasoft.dto.MovieDirectorDto;
import softserve.academy.cinemasoft.dto.MovieRatingDto;
import softserve.academy.cinemasoft.model.Comment;
import softserve.academy.cinemasoft.model.Movie;
import softserve.academy.cinemasoft.service.CategoryService;
import softserve.academy.cinemasoft.service.CommentService;
import softserve.academy.cinemasoft.service.MovieService;
import softserve.academy.cinemasoft.utils.ObjectMapperUtils;

import javax.validation.Valid;
import java.io.IOException;
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
    public String addMovieFromView(@Valid @ModelAttribute("movie") Movie movie, BindingResult bindingResult,
                                   @ModelAttribute("fileImage") MultipartFile imageFile, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("categories", this.categoryService.findAll());
            MultipartFile file = null;
            model.addAttribute("imageFile", file);

            return "add-movie";
        }
        byte[] cover = new byte[0];
        try {
            cover = imageFile.getBytes();
        } catch (IOException e) {
            return "The image is not found";
        }
        movie.setCover(cover);
        movieService.addMovie(movie);

        return "redirect:/";
    }

    @GetMapping("/edit-movie/{id}")
    public String editMovie(@PathVariable int id, Model model) {
        Movie movie = movieService.findMovie(id);
        model.addAttribute("movie", movie);
        model.addAttribute("categories", this.categoryService.findAll());
        MultipartFile file = null;
        model.addAttribute("imageFile", file);

        return "edit-movie";
    }

    @PostMapping("/edit-movie/{id}")
    public String editMovie(@PathVariable int id, @ModelAttribute("movie") Movie movie, BindingResult bindingResult, Model model,
                            @ModelAttribute("fileImage") MultipartFile imageFile) {
        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                log.debug("Printing errors" + error);
            }

            return "redirect:/edit-movie";
        }
        if (imageFile.isEmpty()) {
            movie.setCover(movieService.getMovieById(id).getCover());
        } else {
            byte[] cover = new byte[0];
            try {
                cover = imageFile.getBytes();
            } catch (IOException e) {
                return "The image is not found";
            }
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
    @GetMapping(value = "/searchByDirectorName/{name}")
    public List<MovieDirectorDto> movies(@PathVariable("name") String name) {
        List<Movie> movies = this.movieService.searchMoviesByDirectorName(name);

        return ObjectMapperUtils.mapAll(movies, MovieDirectorDto.class);
    }

    @ResponseBody
    @GetMapping(value = "/ratingGreaterOrEqualThan/{value}")
    public List<MovieRatingDto> getMoviesWithRatingGreaterOrEqualThan(@PathVariable("value") Double value) {
        List<Movie> movies = this.movieService.getMoviesWithRatingGreaterOrEqualThan(value);

        return ObjectMapperUtils.mapAll(movies, MovieRatingDto.class);
    }

}