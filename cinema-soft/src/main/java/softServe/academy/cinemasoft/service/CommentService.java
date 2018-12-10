package softServe.academy.cinemasoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import softServe.academy.cinemasoft.model.Comment;
import softServe.academy.cinemasoft.model.Movie;
import softServe.academy.cinemasoft.repository.CommentRepository;

@Service
public class CommentService {

	private CommentRepository commentRepository;

	@Autowired
	public CommentService(CommentRepository commentRepository) {
		this.commentRepository=commentRepository;
	}
	public Comment addComment(Comment commentToAdd) {
	
	        Comment newComment = new Comment();
	        newComment.setContent(commentToAdd.getContent());
	        return this.commentRepository.save(newComment);
	}

	public void removeComment(int id) {
		Comment commentToDelete = commentRepository.getOne(id);
		if (commentToDelete != null) {
			this.commentRepository.delete(commentToDelete);
		}
	}
	
	public List<Comment> findAll(){
		return commentRepository.findAll();
	}
	
	public List<Comment> findByMovie(Movie movie){
		return commentRepository.findByMovie(movie);
	}
}
