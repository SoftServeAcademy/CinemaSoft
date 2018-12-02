package softServe.academy.cinemasoft.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import softServe.academy.cinemasoft.models.entities.Movie;


@Repository
public interface MovieRepository  extends JpaRepository<Movie, String>{

}
