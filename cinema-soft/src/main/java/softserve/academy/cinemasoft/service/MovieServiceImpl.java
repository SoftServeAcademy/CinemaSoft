package softserve.academy.cinemasoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import softserve.academy.cinemasoft.model.Movie;
import softserve.academy.cinemasoft.repository.MovieRepository;
import softserve.academy.cinemasoft.specification.MovieSpecification;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class MovieServiceImpl implements MovieService {

    private MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> getAllMovie() {
        return this.movieRepository.findAll();
    }

    @Override
    public Movie addMovie(Movie movie) {
        return this.movieRepository.saveAndFlush(movie);
    }

    @Override
    public void deleteMovie(int id) {
        if (this.movieRepository.findById(id).orElse(null) != null) {
            this.movieRepository.deleteById(id);
        }
    }

    @Override
    public Movie editMovie(Movie movie) {
        this.movieRepository.saveAndFlush(movie);
        return movie;
    }

    @Override
    public void editPostMovie(Movie movie) {
        movieRepository.save(movie);
    }

    @Override
    public Movie findMovie(int id) {
        return this.movieRepository.findById(id).orElse(null);
    }

    @Override
    public List<Movie> findAll(Sort sort) {
        return movieRepository.findAll(sort);
    }

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public Movie getMovieById(int id) {
        return movieRepository.getOne(id);
    }

    @Override
    public List<Movie> getMoviesWithRatingGreaterOrEqualThan(double value) {
        return this.movieRepository.findAll(MovieSpecification.movieRatingGreaterThanOrEqualTo(value));
    }

    @Override
    public List<Movie> searchMoviesByDirectorName(String name) {
        return movieRepository.findAll(MovieSpecification.directorNameContains(name));
    }
}
