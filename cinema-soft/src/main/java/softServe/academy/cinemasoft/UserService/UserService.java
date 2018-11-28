package softServe.academy.cinemasoft.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softServe.academy.cinemasoft.dto.UserDTO;
import softServe.academy.cinemasoft.model.Role;
import softServe.academy.cinemasoft.model.User;
import softServe.academy.cinemasoft.repository.UserRepository;

import java.util.Arrays;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;



    public User saveUser(UserDTO userDto){
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setUserName(userDto.getUserName());
        user.setPassword(user.getPassword());//ENCODE PASSWORD LATER!!!
        user.setRoles(Arrays.asList(new Role("ROLE_USER")));
        return userRepository.save(user);
    }

    public User findUserByEmail(String email){
        return this.userRepository.findByEmail(email);
    }
}
