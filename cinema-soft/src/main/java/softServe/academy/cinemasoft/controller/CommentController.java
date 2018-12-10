package softServe.academy.cinemasoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import softServe.academy.cinemasoft.model.Comment;
import softServe.academy.cinemasoft.model.Movie;
import softServe.academy.cinemasoft.service.CommentService;

@Controller
public class CommentController {

	private CommentService commentService;

	@Autowired
	public CommentController(CommentService commentService) {
		this.commentService = commentService;
	}

	@GetMapping("/addComment")
	public String addCommentView(Model model) {
		model.addAttribute("comment", new Comment());
		return "movie";
	}

	// ADD
	@PostMapping("/addComment")
	 @ResponseBody
	    public ResponseEntity<?> addComment(@RequestBody Comment comment){
	        commentService.addComment(comment);
	        return ResponseEntity.status(HttpStatus.CREATED).build();
	    }	

	// GET_ALL
	@GetMapping("/allComments")
	 public ResponseEntity<List<Comment>> getAllComments(){
        return ResponseEntity.ok(this.commentService.findAll());
    }

	// DELETE
	@DeleteMapping(value ="/removeComment/{id}")
    public String removeComment(@PathVariable("id") int Id){
        commentService.removeComment(Id);
        return "redirect:/movie";
    }
	
	//FIND BY MOVIE
	@GetMapping("/comments/{movie}")
    @ResponseBody
    public ResponseEntity<?> getBookById(@PathVariable Movie movie){
        List<Comment> result = commentService.findByMovie(movie);
        if (result !=null){
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
