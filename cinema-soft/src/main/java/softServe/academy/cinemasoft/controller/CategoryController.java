package softServe.academy.cinemasoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import softServe.academy.cinemasoft.model.Category;
import softServe.academy.cinemasoft.service.CategoryService;

@Controller
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public void addCategory(Category category){

        categoryService.addCategory(category);
    }


}
