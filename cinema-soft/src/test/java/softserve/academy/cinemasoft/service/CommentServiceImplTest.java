package softserve.academy.cinemasoft.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import softserve.academy.cinemasoft.model.Comment;
import softserve.academy.cinemasoft.model.Movie;
import softserve.academy.cinemasoft.model.User;
import softserve.academy.cinemasoft.repository.CommentRepository;
import softserve.academy.cinemasoft.repository.MovieRepository;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CommentServiceImplTest {

    @Mock
    private CommentRepository commentRepository;

    @Mock
    private MovieRepository movieRepository;

    private CommentServiceImpl commentService;

    @Before
    public void setUp() {
        commentService = new CommentServiceImpl(commentRepository, movieRepository);
    }

    @Test
    public void testAddComment() {
        User user = new User();
        Comment comment = new Comment();
        when(movieRepository.getOne(anyInt())).thenReturn(Mockito.mock(Movie.class));
        when(commentRepository.save(any(Comment.class))).thenReturn(comment);

        Comment result = commentService.addComment(comment, 1, user);

        verify(commentRepository, only()).save(any(Comment.class));
        assertEquals(comment, result);
    }

    @Test
    public void testRemoveComment() {
        commentService.removeComment(anyInt());
        verify(commentRepository, only()).deleteById(anyInt());
    }

    @Test
    public void testFindById() {
        Comment comment = new Comment();
        when(commentRepository.findById(5)).thenReturn(comment);

        Comment result = commentService.findById(5);

        verify(commentRepository, only()).findById(5);
        assertEquals(comment, result);
    }

    @Test
    public void testFindAll() {
        Comment firstComment = new Comment();
        Comment secondComment = new Comment();
        Comment thirdComment = new Comment();
        List<Comment> listOfComments = List.of(firstComment, secondComment, thirdComment);

        when(commentRepository.findAll()).thenReturn(listOfComments);

        List<Comment> resultList = commentService.findAll();

        verify(commentRepository, only()).findAll();
        assertEquals(resultList, listOfComments);
    }

    @Test
    public void testFindByMovie() {
        List<Comment> listOfComments;
        Comment comment = new Comment();
        listOfComments = List.of(comment);

        Movie movie = new Movie();
        when(commentRepository.findByMovie(movie)).thenReturn(listOfComments);

        List<Comment> resultList = commentService.findByMovie(movie);

        verify(commentRepository, only()).findByMovie(movie);
        assertEquals(resultList, listOfComments);
    }
}
