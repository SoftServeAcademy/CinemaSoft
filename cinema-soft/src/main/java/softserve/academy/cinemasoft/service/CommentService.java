package softserve.academy.cinemasoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import softserve.academy.cinemasoft.model.Comment;
import softserve.academy.cinemasoft.model.Movie;
import softserve.academy.cinemasoft.model.User;
import softserve.academy.cinemasoft.repository.CommentRepository;
import softserve.academy.cinemasoft.repository.MovieRepository;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    private final MovieRepository movieRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository, MovieRepository movieRepository) {
        this.commentRepository = commentRepository;
        this.movieRepository = movieRepository;
    }

    public void addComment(Comment commentToAdd, int movieId, User user) {

        Movie movie = this.movieRepository.getOne(movieId);
        Comment comment = new Comment();

        comment.setContent(commentToAdd.getContent());
        comment.setMovie(movie);
        comment.setUser(user);

        Comment savedComment = this.commentRepository.save(comment);
        movie.addComment(savedComment);

        this.movieRepository.save(movie);
    }

    public void removeComment(int id) {
        Comment commentToDelete = commentRepository.getOne(id);
        if (commentToDelete != null) {
            this.commentRepository.delete(commentToDelete);
        }
    }

    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    public Comment findById(int id){
        return commentRepository.findById(id);
    }
}
