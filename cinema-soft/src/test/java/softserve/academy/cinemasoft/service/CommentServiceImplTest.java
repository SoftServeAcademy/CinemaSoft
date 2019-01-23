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

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

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

        Comment result = commentService.addComment(comment,1, user);

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
        when(commentRepository.findById(anyInt())).thenReturn(comment);

        commentService.findById(5);

        verify(commentRepository, only()).findById(5);
    }

    @Test
    public void testFindAll() {
        commentService.findAll();
        verify(commentRepository, only()).findAll();
    }

    @Test
    public void testFindByMovie() {
        List<Comment> comment;
        Comment comment1 = new Comment();
        comment = List.of(comment1);

        Movie movie = new Movie();
        when(commentRepository.findByMovie(movie)).thenReturn(comment);

        commentService.findByMovie(movie);

        verify(commentRepository, only()).findByMovie(movie);
    }
}
