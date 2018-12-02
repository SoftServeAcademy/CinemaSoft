package softServe.academy.cinemasoft.services;

import java.util.List;

import softServe.academy.cinemasoft.models.entities.Movie;

public interface MovieService {
	
	List<Movie> getAllMovie();
	Movie addMovie(Movie movie);
	void deleteMovie(String id);
	void editMovie(String id);
	Movie findMovie(String id);
	
}
