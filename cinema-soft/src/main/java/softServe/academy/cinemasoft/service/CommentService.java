package softServe.academy.cinemasoft.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import softServe.academy.cinemasoft.entity.Comment;
import softServe.academy.cinemasoft.repository.CommentRepository;

@Service
public class CommentService {
	@Autowired
	private CommentRepository comentRepository;
	
	public Comment addComment(Comment commentToAdd) {
		return this.comentRepository.save(commentToAdd);
	}
	
	
	
}
