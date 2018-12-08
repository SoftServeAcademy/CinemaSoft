package softServe.academy.cinemasoft.service;

import java.util.List;

import softServe.academy.cinemasoft.model.Movie;

public interface MovieService {

    List<Movie> getAllMovie();

    Movie addMovie(Movie movie);

    void deleteMovie(int id);

    void editMovie(int id);

    Movie findMovie(int id);

    Movie getMovieById(int id);

}
