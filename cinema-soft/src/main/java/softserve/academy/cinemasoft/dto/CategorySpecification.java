package softserve.academy.cinemasoft.dto;

import org.springframework.data.jpa.domain.Specification;
import softserve.academy.cinemasoft.model.Category;


public class CategorySpecification {
    public static Specification<Category> categoryNameContains(String name){
        String toFind = "%" + name + "%";
        return ((root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("nameOfCategory"), toFind));
    }
}
