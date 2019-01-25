package softserve.academy.cinemasoft.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import softserve.academy.cinemasoft.model.Category;
import softserve.academy.cinemasoft.repository.CategoryRepository;
import softserve.academy.cinemasoft.repository.MovieRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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

        Category result = categoryService.findCategoryById(5);

        verify(categoryRepository, only()).findById(5);
        assertEquals(category, result);
    }

    @Test
    public void testFindAll() {
        Category firstCategory = new Category();
        Category secondCategory = new Category();
        Category thirdCategory = new Category();
        List<Category> listOfCategories = List.of(firstCategory, secondCategory, thirdCategory);

        when(categoryRepository.findAll()).thenReturn(listOfCategories);

        List<Category> resultList = categoryService.findAll();

        verify(categoryRepository, only()).findAll();
        assertEquals(resultList, listOfCategories);
    }
}