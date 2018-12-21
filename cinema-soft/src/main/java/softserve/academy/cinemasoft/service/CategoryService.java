package softserve.academy.cinemasoft.service;

import softserve.academy.cinemasoft.model.Category;

import java.util.List;

public interface CategoryService {

    Category addCategory(Category categoryToAdd);

    void removeCategory(int id);

    List<Category> findAll();

    void editCategory(int id, String newName);

    Category findCategoryById(int id);
}
