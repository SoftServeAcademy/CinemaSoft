package softserve.academy.cinemasoft.service;

import org.springframework.data.domain.Sort;
import softserve.academy.cinemasoft.model.Movie;

import java.util.List;

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

    List<Movie> getMoviesWithRatingGreaterOrEqualThan(double value);

    List<Movie> searchMoviesByDirectorName(String name);
}
