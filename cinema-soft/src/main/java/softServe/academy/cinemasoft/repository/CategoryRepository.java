package softServe.academy.cinemasoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softServe.academy.cinemasoft.model.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
