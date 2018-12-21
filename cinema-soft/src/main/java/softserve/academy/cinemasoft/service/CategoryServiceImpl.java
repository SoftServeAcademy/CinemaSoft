package softserve.academy.cinemasoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softserve.academy.cinemasoft.model.Category;
import softserve.academy.cinemasoft.repository.CategoryRepository;
import softserve.academy.cinemasoft.repository.MovieRepository;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;


    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category addCategory(Category categoryToAdd) {
        return this.categoryRepository.save(categoryToAdd);
    }

    @Override
    public void removeCategory(int id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public void editCategory(int id, String newName) {
        Category current = categoryRepository.getOne(id);
        if (current != null) {
            String newCategoryName = newName;
            current.setNameOfCategory(newCategoryName);
            categoryRepository.save(current);
        }
    }

    @Override
    public Category findCategoryById(int id) {
        return this.categoryRepository.findById(id).orElse(null);
    }
}
