package softServe.academy.cinemasoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softServe.academy.cinemasoft.model.Category;
import softServe.academy.cinemasoft.repository.CategoryRepository;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category addCategory(Category categoryToAdd){
        return this.categoryRepository.save(categoryToAdd);
    }
}
