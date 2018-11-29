package softServe.academy.cinemasoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softServe.academy.cinemasoft.model.Category;
import softServe.academy.cinemasoft.repository.CategoryRepository;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    public Category addCategory(Category categoryToAdd){
        return this.categoryRepository.save(categoryToAdd);
    }
}
