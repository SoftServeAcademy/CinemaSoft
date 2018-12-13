package softserve.academy.cinemasoft.controller;

import softserve.academy.cinemasoft.service.UserService;
import softserve.academy.cinemasoft.dto.UserDTO;
import softserve.academy.cinemasoft.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }


    @GetMapping("/register")
    public ModelAndView getRegisterForm(Model model){
        model.addAttribute("user", new UserDTO());
        return new ModelAndView("register");
    }

    @PostMapping("/register")
    public String registerUserAccount(@ModelAttribute("user") UserDTO user, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            for(ObjectError error: bindingResult.getAllErrors()){
                System.out.println(error);
            }
        }

        User existing = userService.findUserByEmail(user.getEmail());

        if (existing != null){
            return null;
        }

        userService.saveUser(user);
        return "redirect:/login";
    }
}
