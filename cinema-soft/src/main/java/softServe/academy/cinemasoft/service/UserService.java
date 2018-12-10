package softServe.academy.cinemasoft.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import softServe.academy.cinemasoft.dto.UserDTO;
import softServe.academy.cinemasoft.model.User;


public interface UserService extends UserDetailsService {
    User findUserByEmail(String email);

    User saveUser(UserDTO userDTO);
}
