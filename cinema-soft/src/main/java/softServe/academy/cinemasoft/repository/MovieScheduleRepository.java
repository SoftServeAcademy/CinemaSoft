package softServe.academy.cinemasoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softServe.academy.cinemasoft.model.MovieSchedule;

@Repository
public interface MovieScheduleRepository extends JpaRepository<MovieSchedule, Integer>{

}
