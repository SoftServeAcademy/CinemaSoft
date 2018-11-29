package softServe.academy.cinemasoft.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import softServe.academy.cinemasoft.entity.Comment;


@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer>{


}
