package softServe.academy.cinemasoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import softServe.academy.cinemasoft.model.Comment;
import softServe.academy.cinemasoft.repository.CommentRepository;

@Service
public class CommentService {

	private CommentRepository commentRepository;

	@Autowired
	public CommentService(CommentRepository commentRepository) {
		this.commentRepository=commentRepository;
	}
	public Comment addComment(Comment commentToAdd) {
		return this.commentRepository.save(commentToAdd);
	}

	public void removeComment(Comment comment) {
		commentRepository.delete(comment);
	}
	public List<Comment> findAll(){
		return commentRepository.findAll();
	}
	
//	public List<Comment> findByMovie(Movie movie){
//		return commentRepository.findByMovie(movie);
//	}
}
