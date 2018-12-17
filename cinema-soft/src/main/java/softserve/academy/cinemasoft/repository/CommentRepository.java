package softserve.academy.cinemasoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softserve.academy.cinemasoft.model.Comment;
import softserve.academy.cinemasoft.model.Movie;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

	List<Comment> findByMovie(Movie movie);

	Comment findById(int id);
	
}
