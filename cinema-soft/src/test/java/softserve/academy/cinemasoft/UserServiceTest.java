package softserve.academy.cinemasoft;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import softserve.academy.cinemasoft.dto.UserDto;
import softserve.academy.cinemasoft.model.Role;
import softserve.academy.cinemasoft.model.User;
import softserve.academy.cinemasoft.repository.RoleRepository;
import softserve.academy.cinemasoft.repository.UserRepository;
import softserve.academy.cinemasoft.service.UserServiceImpl;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Autowired
    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private RoleRepository roleRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private BCryptPasswordEncoder passwordEncoder;

    private Role role;

    private String encodedPassword;

    @Before
    public void setUp() {
        role = new Role();
        when(roleRepository.findByName("ROLE_USER")).thenAnswer(invocationOnMock -> role);

        when(userRepository.save(any(User.class))).thenAnswer(invocation -> {
                    User u = invocation.getArgument(0);
                    return u;
                }
        );
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        encodedPassword = encoder.encode("1234");

        when(passwordEncoder.encode("1234")).thenReturn(encodedPassword
        );
    }

    @Test
    public void testPasswordEncryption() {
        UserDto userDTO = new UserDto();
        userDTO.setEmail("email");
        userDTO.setFirstName("name");
        userDTO.setLastName("name");
        userDTO.setUserName("name");
        userDTO.setPassword("1234");

        User user = this.userService.saveUser(userDTO);

        assertThat(user.getPassword()).isEqualTo(encodedPassword);
    }
}
