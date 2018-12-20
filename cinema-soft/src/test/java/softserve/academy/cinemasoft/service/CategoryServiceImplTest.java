package softserve.academy.cinemasoft.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import softserve.academy.cinemasoft.controller.CategoryController;
import softserve.academy.cinemasoft.model.Category;
import softserve.academy.cinemasoft.repository.CategoryRepository;

import static org.junit.Assert.*;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)

public class CategoryServiceImplTest {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryController categoryController;

    @Autowired
    private Category categoryToTest;

    @InjectMocks
    private CategoryServiceImpl categoryService;

    @Test
    public void testAddCategory(){
        //categoryToTest.setId(1);
        categoryService.addCategory(categoryToTest);
        verify(categoryRepository, only()).save(categoryToTest);

    }

}