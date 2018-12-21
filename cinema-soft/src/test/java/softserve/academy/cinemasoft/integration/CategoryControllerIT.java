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
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import softserve.academy.cinemasoft.controller.CategoryController;
import softserve.academy.cinemasoft.model.Category;
import softserve.academy.cinemasoft.repository.CategoryRepository;

import java.net.MalformedURLException;
import java.net.URL;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@WithMockUser(username = "test")
public class CategoryControllerIT {

    @LocalServerPort
    private int port;

    private URL url;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private CategoryRepository categoryRepository;


    @Before
    public void setUp() {
        fillDatabase();
    }

    private void fillDatabase() {
        Category firstCategory = new Category("firstCategoryction");
        Category secondCategory = new Category("secondCategoryction");
        Category thirdCategory = new Category("thirdCategoryction");

        categoryRepository.save(firstCategory);
        categoryRepository.save(secondCategory);
        categoryRepository.save(thirdCategory);
    }

    @Test
    public void testGetAllCategories() throws MalformedURLException {
        url = new URL("http://localhost:" + port + "/all-categories");
        ResponseEntity<String> responseEntity = testRestTemplate.getForEntity(url.toString(), String.class);
        System.out.println(responseEntity.getBody());

        assertThat(responseEntity.getBody().contains("[{\"nameOfcategory\":\"firstCategoryction\"},{\"nameOfcategory\":\"secondCategoryction\"},{\"nameOfcategory\":\"thirdCategoryction\"}]"), equalTo(true));
    }
}
