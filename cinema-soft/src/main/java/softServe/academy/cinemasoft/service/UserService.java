package softServe.academy.cinemasoft.service;

import softServe.academy.cinemasoft.dto.UserDTO;
import softServe.academy.cinemasoft.model.Role;
import softServe.academy.cinemasoft.model.User;
import softServe.academy.cinemasoft.repository.RoleRepository;
import softServe.academy.cinemasoft.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    @Autowired
    public UserService(UserRepository userRepository,RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public User saveUser(UserDTO userDto){
        User user = new User();
        Role role = this.roleRepository.findByName("ROLE_USER");

        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setUserName(userDto.getUserName());
        user.setPassword(userDto.getPassword());//ENCODE PASSWORD LATER!!!
        user.setRoles(Arrays.asList(role));

        return userRepository.save(user);
    }

    public User findUserByEmail(String email){
        return this.userRepository.findByEmail(email);
    }
}
