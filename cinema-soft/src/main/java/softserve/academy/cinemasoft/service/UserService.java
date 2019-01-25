package softserve.academy.cinemasoft.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import softserve.academy.cinemasoft.dto.UserDto;
import softserve.academy.cinemasoft.model.User;

public interface UserService extends UserDetailsService {

    User findUserByEmail(String email);

    User saveUser(UserDto userDto);
}
