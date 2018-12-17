package softServe.academy.cinemasoft.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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
	
	public Movie editMovie(Movie movie) {	       
	        this.movieRepository.saveAndFlush(movie);
	        return movie;
	}
	public void editPostMovie(Movie movie) {
		movieRepository.save(movie);
}

	@Override
	public Movie findMovie(int id) {
		return this.movieRepository.findById(id).orElse(null);
	}

	@Override
	public List<Movie> findAll(Sort sort){
		return movieRepository.findAll(sort);
	}

	@Override
	public List<Movie> findAll(){
		return movieRepository.findAll();
	}

	@Override
	public Movie getMovieById(int id) {
		return movieRepository.getOne(id);
	}
}
