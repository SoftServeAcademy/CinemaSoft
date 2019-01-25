package softserve.academy.cinemasoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softserve.academy.cinemasoft.model.Comment;
import softserve.academy.cinemasoft.model.Movie;
import softserve.academy.cinemasoft.model.User;
import softserve.academy.cinemasoft.repository.CommentRepository;
import softserve.academy.cinemasoft.repository.MovieRepository;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final MovieRepository movieRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, MovieRepository movieRepository) {
        this.commentRepository = commentRepository;
        this.movieRepository = movieRepository;
    }

    @Override
    public Comment addComment(Comment commentToAdd, int movieId, User user) {

        Movie movie = this.movieRepository.getOne(movieId);
        Comment comment = new Comment();

        comment.setContent(commentToAdd.getContent());
        comment.setMovie(movie);
        comment.setUser(user);

        Comment savedComment = this.commentRepository.save(comment);
        movie.addComment(savedComment);

        this.movieRepository.save(movie);

        return savedComment;
    }

    @Override
    public void removeComment(int id) {
        commentRepository.deleteById(id);
    }

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Comment findById(int id) {
        return commentRepository.findById(id);
    }

    @Override
    public List<Comment> findByMovie(Movie movie) {
        return this.commentRepository.findByMovie(movie);
    }
}
