package softServe.academy.cinemasoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softServe.academy.cinemasoft.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

	//List<Comment> findByMovie(Movie movie);
	
}
