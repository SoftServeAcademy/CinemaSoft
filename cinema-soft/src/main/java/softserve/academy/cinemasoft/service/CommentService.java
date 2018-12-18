package softserve.academy.cinemasoft.service;

import java.util.Date;
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

    public Comment addComment(Comment comment) {
        Date date = new Date();
        comment.setDateOfComment(date);

        return this.commentRepository.save(comment);

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

    public Comment findById(int id) {
        return commentRepository.findById(id);
    }
}
