package softserve.academy.cinemasoft.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import softserve.academy.cinemasoft.controller.CategoryController;
import softserve.academy.cinemasoft.model.Category;
import softserve.academy.cinemasoft.repository.CategoryRepository;
import softserve.academy.cinemasoft.repository.MovieRepository;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)

public class CategoryServiceImplTest {


    @Mock
    private CategoryRepository categoryRepository;

    @Mock
    private MovieRepository movieRepository;

    private CategoryServiceImpl categoryService;

    @Before
    public void setUp() {
        categoryService = new CategoryServiceImpl(categoryRepository);
    }

    @Test
    public void testAddCategory() {
        Category category = new Category();
        when(categoryRepository.save(category)).thenReturn(category);

        Category result = categoryService.addCategory(category);

        verify(categoryRepository, only()).save(category);
        assertEquals(category, result);
    }

    @Test
    public void testRemoveCategory() {
        Category category = new Category();
        categoryService.removeCategory(1);

        verify(categoryRepository, only()).deleteById(1);
    }

    @Test
    public void testEditCategory() {
        Category category = new Category();
        when(categoryRepository.save(category)).thenReturn(category);
        when(categoryRepository.getOne(anyInt())).thenReturn(category);

        categoryService.editCategory(5, "");

        verify(categoryRepository, times(1)).save(category);
        verify(categoryRepository, times(1)).getOne(5);
    }

    @Test
    public void testFindCategoryById() {
        Category category = new Category();
        when(categoryRepository.findById(anyInt())).thenReturn(Optional.of(category));

        categoryService.findCategoryById(5);

        verify(categoryRepository, only()).findById(5);
    }

    @Test
    public void testFindAll() {
        categoryService.findAll();
        verify(categoryRepository, only()).findAll();
    }


}