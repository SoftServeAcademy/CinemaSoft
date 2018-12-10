package softServe.academy.cinemasoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softServe.academy.cinemasoft.model.Category;
import softServe.academy.cinemasoft.repository.CategoryRepository;

import java.util.List;

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

    public void removeCategory(Category category) {
        categoryRepository.delete(category);
    }

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public Category getCategoryById(int id){
        return categoryRepository.getOne(id);
    }

    public void editCategory(int id, String newName){
        Category current = categoryRepository.getOne(id);
        if(current != null){
            String newCategoryName = newName;
            current.setNameOfCategory(newCategoryName);
            categoryRepository.save(current);
        }
    }
}
