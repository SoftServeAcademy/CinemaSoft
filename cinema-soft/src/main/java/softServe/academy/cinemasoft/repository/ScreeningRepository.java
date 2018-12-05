package softServe.academy.cinemasoft.repository;

import softServe.academy.cinemasoft.model.Screening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ScreeningRepository extends JpaRepository <Screening, Integer> {

    //List<Screening> findAllScreenings();

}
