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

@Controller
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/add-category")
    public String addCategoryView(Model model){
        model.addAttribute("category", new Category());
        return "add-category";
    }

    @PostMapping("/add-category")
    public String addCategoryFromView(@ModelAttribute("category") Category category, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            for(ObjectError error : bindingResult.getAllErrors()){
                System.out.println(error);
            }
        }
        categoryService.addCategory(category);

        return "redirect:/add-category";
    }

}
