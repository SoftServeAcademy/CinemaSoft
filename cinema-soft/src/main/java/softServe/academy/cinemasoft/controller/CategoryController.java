package softServe.academy.cinemasoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import softServe.academy.cinemasoft.service.CategoryService;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
}
