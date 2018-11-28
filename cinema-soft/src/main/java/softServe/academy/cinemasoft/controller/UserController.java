package softServe.academy.cinemasoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import softServe.academy.cinemasoft.UserService.UserService;
import softServe.academy.cinemasoft.dto.UserDTO;
import softServe.academy.cinemasoft.model.User;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String getRegisterForm(){
        return "register";
    }

    @PostMapping("/register")
    public String registerUserAccount(@Valid UserDTO userDto){

        User existing = userService.findUserByEmail(userDto.getEmail());
        if (existing != null){
            return null;
        }

        userService.saveUser(userDto);
        return "redirect:/login";
    }
}
