package softServe.academy.cinemasoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import softServe.academy.cinemasoft.model.Comment;
import softServe.academy.cinemasoft.model.Movie;
import softServe.academy.cinemasoft.model.User;
import softServe.academy.cinemasoft.service.CommentService;
import softServe.academy.cinemasoft.service.UserService;

@Controller
public class CommentController {

    private final CommentService commentService;

    private final UserService userService;

    @Autowired
    public CommentController(CommentService commentService, UserService userService) {
        this.commentService = commentService;
        this.userService = userService;
    }

    @PostMapping("/addComment")
    public String addComment(@ModelAttribute("comment") Comment comment, @ModelAttribute("movieId") int movieId, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                System.out.println(error);
            }
        }
        UserDetails user = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        User userEntity = this.userService.findUserByEmail(user.getUsername());

        commentService.addComment(comment,movieId,userEntity);
        return "redirect:/index";
    }

    // GET_ALL
    @GetMapping("/allComments")
    public ResponseEntity<List<Comment>> getAllComments() {
        return ResponseEntity.ok(this.commentService.findAll());
    }

    // DELETE
    @DeleteMapping(value = "/removeComment/{id}")
    public String removeComment(@PathVariable("id") int Id) {
        commentService.removeComment(Id);
        return "redirect:/movie";
    }

    //FIND BY MOVIE
    @GetMapping("/comments/{movie}")
    @ResponseBody
    public ResponseEntity<?> getBookById(@PathVariable Movie movie) {
        List<Comment> result = commentService.findByMovie(movie);
        if (result != null) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
