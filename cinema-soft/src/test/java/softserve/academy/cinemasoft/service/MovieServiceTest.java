package softserve.academy.cinemasoft.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import softserve.academy.cinemasoft.model.Movie;
import softserve.academy.cinemasoft.repository.MovieRepository;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MovieServiceTest {

    @Mock
    private MovieRepository movieRepository;

    @InjectMocks
    private MovieServiceImpl movieServiceImpl;

    private List<Movie> allMovies;

    @Mock
    private Movie movieToTest;

    @Before
    public void setUp() {

        Movie first = new Movie();
        Movie second = new Movie();
        Movie third = new Movie();

  //      allMovies = List.of(first, second, third);
        when(movieRepository.findAll()).thenReturn(allMovies);

        when(movieRepository.saveAndFlush(any(Movie.class))).thenAnswer(
                invocation -> {
                    Movie movie = invocation.getArgument(0);

//                    if(movie.getTitle() == null){
//                        throw new IllegalArgumentException("No title");
//                    }
//
//                    if(movie.getDirector() == null){
//                        throw new IllegalArgumentException("No director");
//                    }
//
//                    if(movie.getCast() == null){
//                        throw new IllegalArgumentException("no cast");
//                    }
//
//                    if (movie.getCategory() == null){
//                        throw new IllegalArgumentException("no category");
//                    }
//
//                    if(movie.getComment() == null){
//                        throw new IllegalArgumentException("no comment");
//                    }
//
//                    if(movie.getScreenings() == null){
//                        throw new IllegalArgumentException("No screenings");
//                    }
//
//                    if(movie.getComment().isEmpty()){
//                        throw new IllegalArgumentException("no cover");
//                    }
//
//                    if(movie.getDescription() == null){
//                        throw new IllegalArgumentException("no description");
//                    }
//
//                    if(movie.getTrailer() == null){
//                        throw new IllegalArgumentException("no trailer");
//                    }
//
//                    if(movie.getDuration() == 0){
//                        throw new IllegalArgumentException("no correct duration");
//                    }
//
//                    if(movie.getRating() == 0){
//                        throw new IllegalArgumentException("no correct rating");
//                    }

                    movie.setId(4);
                    return movie;
                }
        );
    }

    @Test
    public void testGetAllMovies() {
        movieServiceImpl.findAll();
        verify(movieRepository, only()).findAll();
    }

    @Test
    public void testDeleteMovieById() {
        Optional<Movie> movieOptional = Optional.of(movieToTest);
        when(movieRepository.findById(anyInt())).thenReturn(movieOptional);
        movieServiceImpl.deleteMovie(anyInt());
        verify(movieRepository, times(1)).deleteById(anyInt());
    }

    @Test
    public void testEditMovie(){
        movieServiceImpl.editMovie(movieToTest);
        verify(movieRepository, only()).saveAndFlush(movieToTest);
    }

    @Test
    public void testEditPostMovie(){
        movieServiceImpl.editPostMovie(movieToTest);
        verify(movieRepository, only()).save(movieToTest);
    }

    @Test
    public void testGetMovieById(){
        movieServiceImpl.getMovieById(anyInt());
        verify(movieRepository, only()).getOne(anyInt());
    }

    @Test
    public void testSaveMovie(){
        Movie movie = new Movie();
        movie = movieServiceImpl.addMovie(movie);
        assertThat(movie.getId()).isEqualTo(4);
    }
}
