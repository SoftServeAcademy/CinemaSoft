package softServe.academy.cinemasoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import softServe.academy.cinemasoft.model.Comment;
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
		return "movie.html";
	}

	// ADD
	@PostMapping("/addComment")
	public String addCommentFromView(@ModelAttribute("comment") Comment comment, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			for (ObjectError error : bindingResult.getAllErrors()) {
				System.out.println(error);
			}
		}
		commentService.addComment(comment);
		return "redirect:/addComment";
	}

	// GET_ALL
	@GetMapping("/allComments")
	public ModelAndView getComment(Model model) {
		ModelAndView modelAndView = new ModelAndView("list-comments");
		modelAndView.addObject("comment", commentService.findAll());
		return modelAndView;
	}

	// DELETE
	@RequestMapping(value = "/deleteComment", method = RequestMethod.POST, params = { "delete" })
	public String deleteCommentView(@ModelAttribute("comment") Comment comment) {
		commentService.removeComment(comment);
		return "redirect:/allComments";
	}
	
	//MOVIE_BY_NAME
	//@GetMapping("/comments/{movie}")
   // @ResponseBody
//    public ResponseEntity<?> getBookById(@PathVariable Movie movie){
//        Comment result = commentService.findByMovie(movie);
//        if (result !=null){
//            return ResponseEntity.ok(result);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
}
