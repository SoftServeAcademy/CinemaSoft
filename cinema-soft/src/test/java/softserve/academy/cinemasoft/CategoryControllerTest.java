package softserve.academy.cinemasoft;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import softserve.academy.cinemasoft.controller.CategoryController;
import softserve.academy.cinemasoft.service.CategoryService;


import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.hamcrest.CoreMatchers.*;



import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.asyncDispatch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;


import org.springframework.http.MediaType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private CategoryController categoryController;

    @InjectMocks
    private CategoryService categoryService;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(categoryController).build();
    }

    @Test
    public void testViewIsOk() throws Exception {


//        Category first = new Category("first");
//        Category second = new Category("second");
//
//        when(categoryService.findAll()).thenReturn(Arrays.asList(first,second));
        mockMvc.perform(get("/categories"))
                .andExpect(status().isOk())
                .andExpect(view().name("list-category"));
    }

    @Test
    public void someTest() throws Exception {
//        mockMvc.perform(get("http://localhost:8080/all-categories").content(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.nameOfCategory"), hasSize(3));
//                .andExpect(jsonPath("$.nameOfCategory", Matchers.containsInAnyOrder("action", "maction", "satisfaction")));
    }


    @Test
    public void contextLoads() throws Exception{
        assertThat(categoryController).isNotNull();
    }


//    private MockMvc mockMvc;
//
//    @Mock
//    private CategoryRepository categoryRepository;
//
//    @InjectMocks
//    private CategoryController categoryController;
//
//    @Before
//    public void setUp(){
//        JacksonTester.initFields(this, new ObjectMapper());
//        mockMvc = MockMvcBuilders.standaloneSetup(categoryController)
//                .build();
//
//    }
//
//    @Test
//    public void findCategoryById() throws Exception {
//        given(categoryRepository.findById(12)).willReturn(java.util.Optional.of(new Category("thriller")));
//        MockHttpServletResponse response = mockMvc.perform(get("/editCategory/12").accept(MediaType.APPLICATION_JSON))
//                .andReturn().getResponse();
//        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
//    }
//
}
