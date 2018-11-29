package softServe.academy.cinemasoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softServe.academy.cinemasoft.entity.MovieSchedule;

import java.util.List;


@Repository
public interface MovieScheduleRepository extends JpaRepository<MovieSchedule, Integer>{

    List<MovieSchedule> findByName(String name);
}
