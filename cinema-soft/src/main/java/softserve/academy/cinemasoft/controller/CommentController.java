
package softserve.academy.cinemasoft.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import softserve.academy.cinemasoft.model.Comment;
import softserve.academy.cinemasoft.model.Movie;
import softserve.academy.cinemasoft.model.User;
import softserve.academy.cinemasoft.repository.MovieRepository;
import softserve.academy.cinemasoft.service.CommentService;
import softserve.academy.cinemasoft.service.MovieService;
import softserve.academy.cinemasoft.service.UserService;

@Controller
public class CommentController {

    private final CommentService commentService;

    private final UserService userService;

    private MovieRepository movieRepository;

    private MovieService movieService;

    @Autowired
    public CommentController(CommentService commentService, UserService userService, MovieRepository movieRepository, MovieService movieService) {
        this.commentService = commentService;
        this.userService = userService;
        this.movieRepository = movieRepository;
        this.movieService = movieService;
    }

    @PostMapping("/addComment")
    public String addComment(@ModelAttribute("comment") Comment comment, @ModelAttribute("movieId") int movieId, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {

        }

        UserDetails user = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        User userEntity = this.userService.findUserByEmail(user.getUsername());

        Movie movie = this.movieService.findMovie(movieId);

        comment.setUser(userEntity);
        comment.setMovie(movie);

        Comment savedComment = commentService.saveComment(comment);

        movie.addComment(savedComment);
        this.movieRepository.save(movie);

        return "redirect:/movie/" + movieId;
    }


    // DELETE
    @DeleteMapping(value = "/removeComment/{id}")
    public String removeComment(@PathVariable("id") int Id) {
        Comment comment = this.commentService.findById(Id);
        commentService.removeComment(Id);

        return "redirect:/movie/" + comment.getMovie().getId();
    }
}
