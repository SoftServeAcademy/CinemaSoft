package softserve.academy.cinemasoft.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import softserve.academy.cinemasoft.model.Movie;

public interface MovieService {

    List<Movie> getAllMovie();

    Movie addMovie(Movie movie);

    void deleteMovie(int id);

    Movie editMovie(Movie movie);

    Movie findMovie(int id);

    List<Movie> findAll(Sort sort);

    Movie getMovieById(int id);
     List<Movie> findAll();

	 void editPostMovie(Movie movie);
}
