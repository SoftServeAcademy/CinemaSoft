package softServe.academy.cinemasoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import softServe.academy.cinemasoft.model.Category;
import softServe.academy.cinemasoft.model.Movie;
import softServe.academy.cinemasoft.repository.MovieRepository;
import softServe.academy.cinemasoft.service.CategoryService;
import org.springframework.web.servlet.ModelAndView;
import softServe.academy.cinemasoft.service.MovieService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Controller
public class CategoryController {

    private CategoryService categoryService;
    //  private MovieService movieService;
    private MovieService movieService;
//    @Autowired
//    public CategoryController(CategoryService categoryService) {
//        this.categoryService = categoryService;
//    }

    @Autowired
    public CategoryController(CategoryService categoryService, MovieService movieService) {
        this.categoryService = categoryService;
        this.movieService = movieService;
    }

    @GetMapping("/add-category")
    public String addCategoryView(Model model) {
        model.addAttribute("category", new Category());
        return "add-category";
    }

    @PostMapping("/add-category")
    public String addCategoryFromView(@ModelAttribute("category") Category category, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                System.out.println(error);
            }
        }
        categoryService.addCategory(category);
        return "redirect:/add-category";
    }

    @GetMapping("/categories")
    public ModelAndView getCategories(Model model) {
        ModelAndView modelAndView = new ModelAndView("list-category");
        modelAndView.addObject("categories", categoryService.findAll());
        return modelAndView;
    }

    @RequestMapping(value = "/editCategory", method = RequestMethod.POST, params = {"delete"})
    public String deleteCategoryView(@ModelAttribute("category") Category category) {
        categoryService.removeCategory(category);
        return "redirect:/categories";
    }

    @RequestMapping(value = "/editCategory", method = RequestMethod.POST, params = {"edit"})
    public String editCategoryView(@ModelAttribute("category") Category category) {
        return "redirect:/categories";
    }

//    @GetMapping("/index")
//    public String showIndexView(){
//        return "index";
//    }

    @GetMapping("/index")
    public ModelAndView showAllMovies(Model model) {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("movies", movieService.getAllMovie());
        return modelAndView;
    }

//    @GetMapping("/movie")
//    public String showMovie() {
//        return "movie";
//    }

//    @GetMapping(value = "/movie/{id}")
//    public ModelAndView showMovieById(@PathVariable("id") int id) {
//        ModelAndView modelAndView = new ModelAndView("movie");
//        modelAndView.addObject("selectMovie", movieService.getMovieById(id));
//        return modelAndView;
//    }
}
