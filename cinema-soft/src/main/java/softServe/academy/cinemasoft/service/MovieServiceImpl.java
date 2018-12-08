package softServe.academy.cinemasoft.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import softServe.academy.cinemasoft.model.Category;
import softServe.academy.cinemasoft.model.Movie;
import softServe.academy.cinemasoft.repository.MovieRepository;

@Service
@Transactional
public class MovieServiceImpl implements MovieService{

	private MovieRepository movieRepository ;

	@Autowired
    public  MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }	

	public List<Movie> getAllMovie() {		
		return this.movieRepository.findAll();
	}
	
	public Movie addMovie(Movie movie) {
		return this.movieRepository.saveAndFlush(movie);
	}


	public void deleteMovie(int id) {
        if(this.movieRepository.findById(id).orElse(null) != null) {
            this.movieRepository.deleteById(id);
        }
    }
	
	public void editMovie(int id) {
	        Movie movie = this.movieRepository
	        		.findById(id)
	                .orElse(null);

	        if(movie == null) return;
	        
	        this.movieRepository.saveAndFlush(movie);		
	}

	@Override
	public Movie findMovie(int id) {
		return this.movieRepository.findById(id).orElse(null);
	}

	@Override
	public Movie getMovieById(int id) {
		return movieRepository.getOne(id);
	}


}
