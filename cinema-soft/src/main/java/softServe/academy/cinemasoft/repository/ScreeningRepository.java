package softServe.academy.cinemasoft.repository;

import softServe.academy.cinemasoft.model.Screening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScreeningRepository extends JpaRepository <Screening, Integer> { // Sprqmo primary key-a ili?

}
