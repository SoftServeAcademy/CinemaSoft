package softserve.academy.cinemasoft;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import softserve.academy.cinemasoft.model.Comment;
import softserve.academy.cinemasoft.model.Movie;
import softserve.academy.cinemasoft.model.User;
import softserve.academy.cinemasoft.repository.CommentRepository;
import softserve.academy.cinemasoft.service.CommentService;
import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class CommentServiceTest {

    @Autowired
    @InjectMocks
    private CommentService commentService;

    @Mock
    private CommentRepository commentRepository;

    private User user;

    private Movie movie;

    @Before
    public void setUp() {
        movie= new Movie();
        user = new User();

        when(commentRepository.save(any(Comment.class))).thenAnswer(
                invocation ->{
                    Comment c = invocation.getArgument(0);
                    return c;
                }
        );
    }

    @Test
    public void testSave() {
        Comment comment = new Comment();
        comment.setId(1);
        comment.setMovie(movie);
        comment.setUser(user);
        comment.setContent("test");
        comment = commentService.saveComment(comment);

        assertThat(comment.getDateOfComment()).isNotNull();
    }
}
