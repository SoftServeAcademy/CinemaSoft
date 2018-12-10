package softServe.academy.cinemasoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import softServe.academy.cinemasoft.model.Category;
import softServe.academy.cinemasoft.model.Comment;
import softServe.academy.cinemasoft.model.Movie;
import softServe.academy.cinemasoft.repository.CommentRepository;
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
    private MovieService movieService;
    private CommentRepository commentRepository;

    @Autowired
    public CategoryController(CategoryService categoryService, MovieService movieService,CommentRepository commentRepository) {
        this.categoryService = categoryService;
        this.movieService = movieService;
        this.commentRepository =  commentRepository;
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
    	System.out.println(category);
        return "redirect:/categories";
    }

//    @GetMapping("/index")
//    public String showIndexView(){
//        return "index";
//    }

    @GetMapping("/index")
    public ModelAndView showAllMovies(Model model) {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("movies", movieService.findAll(new Sort(Sort.Direction.DESC, "rating")));
        return modelAndView;
    }

//    @GetMapping("/movie")
//    public String showMovie() {
//        return "movie";
//    }


    @GetMapping(value = "/movie/{id}")
    public ModelAndView showMovieById(@PathVariable("id") int id,Model model) {
        ModelAndView modelAndView = new ModelAndView("movie");
        modelAndView.addObject("selectMovie", movieService.getMovieById(id));
        model.addAttribute("comment", new Comment());
        model.addAttribute("comments", commentRepository.findByMovie(movieService.getMovieById(id)));
        return modelAndView;
    }

    @GetMapping("/editCategory/{id}")
   public ModelAndView showEditCategoryView(@PathVariable("id") int id){
        Category selectedCategory = categoryService.getCategoryById(id);
        ModelAndView modelAndView = new ModelAndView("edit-category");
        modelAndView.addObject("category", selectedCategory);
        return modelAndView;
    }

    @PostMapping("editCategory/{id}")
    public String editCategory(@ModelAttribute("category") Category category, @PathVariable("id") int id){
        String newName = category.getNameOfCategory();
        categoryService.editCategory(id, newName);
        return "redirect:/categories";
    }
//    @GetMapping(value = "/movie/{id}")
//    public ModelAndView showMovieById(@PathVariable("id") int id) {
//        ModelAndView modelAndView = new ModelAndView("movie");
//        modelAndView.addObject("selectMovie", movieService.getMovieById(id));
//        return modelAndView;
//    }
}
