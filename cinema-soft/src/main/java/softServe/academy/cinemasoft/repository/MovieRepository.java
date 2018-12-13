package softServe.academy.cinemasoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import softServe.academy.cinemasoft.model.Movie;

public interface MovieRepository extends JpaRepository<Movie,Integer> {
}
