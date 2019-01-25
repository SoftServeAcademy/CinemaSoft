package softserve.academy.cinemasoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softserve.academy.cinemasoft.model.Screening;

@Repository
public interface ScreeningRepository extends JpaRepository<Screening, Integer> {
    Screening findById(int id);
}
