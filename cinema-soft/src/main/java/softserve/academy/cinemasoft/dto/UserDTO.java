package softserve.academy.cinemasoft.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
public class UserDTO {

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @NotEmpty
    private String userName;

    @NotEmpty
    private String password;

    @Email
    @NotEmpty
    private String email;



}
