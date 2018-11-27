package softServe.academy.cinemasoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import softServe.academy.cinemasoft.CategoryService.CategoryService;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


}
