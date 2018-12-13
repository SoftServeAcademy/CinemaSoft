package softserve.academy.cinemasoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import softserve.academy.cinemasoft.model.Movie;


@Repository
public interface MovieRepository  extends JpaRepository<Movie, Integer>{
}
