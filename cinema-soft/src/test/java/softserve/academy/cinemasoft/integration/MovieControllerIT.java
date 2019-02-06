package softserve.academy.cinemasoft.integration;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.test.context.junit4.SpringRunner;
import softserve.academy.cinemasoft.model.Category;
import softserve.academy.cinemasoft.model.Movie;
import softserve.academy.cinemasoft.repository.CategoryRepository;
import softserve.academy.cinemasoft.repository.MovieRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class MovieControllerIT {

    @LocalServerPort
    private int port;

    private URL directorsUrl;
    private URL ratingUrl;

    @Autowired
    private TestRestTemplate template;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Before
    public void setUp() throws Exception {
        fillDatabase();
    }

    @Test
    public void getDirectors() throws MalformedURLException {
        this.directorsUrl = new URL("http://localhost:" + port + "/" + "searchByDirectorName/" + "Dir");
        ResponseEntity<String> response = template.getForEntity(directorsUrl.toString(), String.class);
        assertThat(response.getBody().contains("[{\"title\":\"Test Title\",\"director\":\"Test Director\"}]"), equalTo(true));
    }

    @Test
    public void getNoDirectors() throws MalformedURLException {
        this.directorsUrl = new URL("http://localhost:" + port + "/" + "searchByDirectorName/" + "Dir");
        ResponseEntity<String> response = template.getForEntity(directorsUrl.toString(), String.class);
        assertThat(response.getBody().contains("[]"), equalTo(false));
    }

    @Test
    public void getMoviesRating() throws MalformedURLException {
        this.ratingUrl = new URL("http://localhost:" + port + "/" + "ratingGreaterOrEqualThan/" + "3");
        ResponseEntity<String> response = template.getForEntity(ratingUrl.toString(), String.class);
        assertThat(response.getBody().contains("[{\"title\":\"Test Title\",\"rating\":3.1}]"), equalTo(true));
    }

    @Test
    public void getLessMoviesRating() throws MalformedURLException {
        this.ratingUrl = new URL("http://localhost:" + port + "/" + "ratingGreaterOrEqualThan/" + "3");
        ResponseEntity<String> response = template.getForEntity(ratingUrl.toString(), String.class);
        assertThat(response.getBody().contains("[]"), equalTo(false));
    }

    private void fillDatabase() {
        Category category = new Category();
        category.setNameOfCategory("categoryName");
        categoryRepository.save(category);
        Movie movie = new Movie();

        movie.setTitle("Test Title");
        movie.setCategory(category);
        movie.setCast("Test Cast");
        movie.setDescription("Test Description");
        movie.setDuration(30);
        movie.setTrailer("Test Trailer");
        movie.setDirector("Test Director");
        movie.setRating(3.1);
        movieRepository.save(movie);
    }
}
