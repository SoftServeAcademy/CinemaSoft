package softserve.academy.cinemasoft.repository;

import softserve.academy.cinemasoft.model.Screening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public interface ScreeningRepository extends JpaRepository <Screening, Integer> {
    Screening findById(int id);
}
