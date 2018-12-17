package softserve.academy.cinemasoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softserve.academy.cinemasoft.model.Category;
import softserve.academy.cinemasoft.repository.CategoryRepository;
import softserve.academy.cinemasoft.repository.MovieRepository;

import java.util.List;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;
    private MovieRepository movieRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository, MovieRepository movieRepository) {
        this.categoryRepository = categoryRepository;
        this.movieRepository = movieRepository;
    }

    public Category addCategory(Category categoryToAdd) {
        return this.categoryRepository.save(categoryToAdd);
    }

    public void removeCategory(int id) {
        categoryRepository.deleteById(id);
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public void editCategory(int id, String newName) {
        Category current = categoryRepository.getOne(id);
        if (current != null) {
            String newCategoryName = newName;
            current.setNameOfCategory(newCategoryName);
            categoryRepository.save(current);
        }
    }

    public Category findCategoryById(int id){
        return this.categoryRepository.findById(id).orElse(null);
    }
}
