package softserve.academy.cinemasoft.service;

import softserve.academy.cinemasoft.model.Comment;
import softserve.academy.cinemasoft.model.User;

import java.util.List;

public interface CommentService {

    Comment addComment(Comment commentToAdd, int movieId, User user);

    void removeComment(int id);

    List<Comment> findAll();

    Comment findById(int id);
}
