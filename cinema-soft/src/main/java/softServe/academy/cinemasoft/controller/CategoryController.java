package softServe.academy.cinemasoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import softServe.academy.cinemasoft.model.entities.Category;
import softServe.academy.cinemasoft.service.CategoryService;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
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
<<<<<<< HEAD

    @GetMapping("/index")
    public String indexView(Model model) {
        //model.addAttribute("category", new Category());
        return "index";
=======
    @GetMapping("/index")
    public String showIndexView(){
        return "index";
    }
    @RequestMapping(value="/editCategory", method = RequestMethod.POST, params = {"edit"})
    public String editCategoryView(@ModelAttribute("category") Category category){
        return  "redirect:/categories";
>>>>>>> fd3974598d4efc952451a7dd70d08d06660c8717
    }
}
