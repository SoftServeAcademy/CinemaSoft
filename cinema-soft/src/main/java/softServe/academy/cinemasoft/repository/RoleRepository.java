package softServe.academy.cinemasoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softServe.academy.cinemasoft.model.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {

}
