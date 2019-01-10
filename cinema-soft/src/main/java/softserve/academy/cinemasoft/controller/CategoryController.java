package softserve.academy.cinemasoft.controller;

import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
import org.springframework.web.servlet.ModelAndView;
import softserve.academy.cinemasoft.dto.CategoryDto;
import softserve.academy.cinemasoft.dto.MovieDirectorDto;
import softserve.academy.cinemasoft.model.Category;
import softserve.academy.cinemasoft.model.Movie;
import softserve.academy.cinemasoft.repository.CategoryRepository;
import softserve.academy.cinemasoft.repository.CommentRepository;
import softserve.academy.cinemasoft.service.CategoryService;
import softserve.academy.cinemasoft.service.MovieService;
import softserve.academy.cinemasoft.specification.CategorySpecification;
import softserve.academy.cinemasoft.utils.ObjectMapperUtils;


@Controller
public class CategoryController {

    private CategoryService categoryService;
    private MovieService movieService;
    private CommentRepository commentRepository;
    private ModelMapper modelMapper;
    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryController(CategoryService categoryService, MovieService movieService, CommentRepository commentRepository,
                              CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryService = categoryService;
        this.movieService = movieService;
        this.commentRepository = commentRepository;
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
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

    @DeleteMapping("/deleteCategory/{id}")
    public String deleteCategory(@PathVariable int id) {

        categoryService.removeCategory(id);

        return "redirect:/categories";
    }

    @GetMapping("/editCategory/{id}")
    public String editCategory(@PathVariable int id, Model model) {

        Category category = categoryService.findCategoryById(id);
        model.addAttribute("category", category);

        return "edit-category";
    }

    @PostMapping("editCategory/{id}")
    public String editCategory(@ModelAttribute("category") Category category, @PathVariable("id") int id) {
        String newName = category.getNameOfCategory();
        categoryService.editCategory(id, newName);

        return "redirect:/categories";
    }

    @GetMapping("/")
    public ModelAndView showAllMovies(Model model) {

        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("movies", movieService.findAll(new Sort(Sort.Direction.DESC, "rating")));
        modelAndView.addObject("categories", categoryService.findAll());

        //load cover for each movie
        List<Movie> allMovies = movieService.findAll();
        HashMap<Integer, String> movieCovers = new HashMap<>();
        for (int i = 0; i < allMovies.size(); i++) {
            String currentCover = Base64.getEncoder().encodeToString(allMovies.get(i).getCover());
            movieCovers.put(allMovies.get(i).getId(), currentCover);
        }

        model.addAttribute("images", movieCovers);

        return modelAndView;
    }


    @GetMapping("/all-categories")
    @ResponseBody
    public List<CategoryDto> getAllCategories() {
        List<Category> allCategories = categoryRepository.findAll(CategorySpecification.categoryNameContains("ction"));
        List<CategoryDto> mappedCategories = new ArrayList<>();

        for (Category category : allCategories) {
            CategoryDto categoryDto = ObjectMapperUtils.map(category, CategoryDto.class);
            mappedCategories.add(categoryDto);
        }

        return mappedCategories;
    }
}
