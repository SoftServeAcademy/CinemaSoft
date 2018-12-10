package softServe.academy.cinemasoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import softServe.academy.cinemasoft.model.Comment;
import softServe.academy.cinemasoft.model.Movie;
import softServe.academy.cinemasoft.repository.CommentRepository;
import softServe.academy.cinemasoft.repository.MovieRepository;

@Service
public class CommentService {

	private CommentRepository commentRepository;
	
	private MovieRepository movieRepository;

	@Autowired
	public CommentService(CommentRepository commentRepository, MovieRepository movieRepository) {
		this.commentRepository=commentRepository;
		this.movieRepository=movieRepository;
	}
	public Comment addComment(Comment commentToAdd,int movieId) {
	
		  Movie newMovie = this.movieRepository.getOne(movieId);
	        Comment newComment = new Comment();
	        newComment.setContent(commentToAdd.getContent());
	        newComment.setMovie(newMovie);
	        Comment savedComment = this.commentRepository.save(newComment);
	       
	        newMovie.addComment(savedComment);
	        this.movieRepository.save(newMovie);
	        
	        return savedComment;
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
