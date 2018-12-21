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

    @Autowired
    private TestRestTemplate template;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Before
    public void setUp() throws Exception {

        this.directorsUrl = new URL("http://localhost:" + port + "/" + "searchByDirectorName/" + "Dir");
        fillDatabase();
    }

    @Test
    public void getDirectors() {
        ResponseEntity<String> response = template.getForEntity(directorsUrl.toString(), String.class);
        assertThat(response.getBody().contains("[{\"title\":\"Test Title\",\"director\":\"Test Director\"}]"), equalTo(true));
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
        movie.setRating(5);
        movie.setTrailer("Test Trailer");
        movie.setDirector("Test Director");
        movieRepository.save(movie);
    }
}
