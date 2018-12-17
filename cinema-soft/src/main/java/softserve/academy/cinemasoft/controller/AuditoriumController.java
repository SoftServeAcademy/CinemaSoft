package softserve.academy.cinemasoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import softserve.academy.cinemasoft.model.Auditorium;
import softserve.academy.cinemasoft.service.AuditoriumService;

@Controller
public class AuditoriumController {

	private AuditoriumService auditoriumService;

	@Autowired
	public AuditoriumController(AuditoriumService auditoriumService) {
		this.auditoriumService = auditoriumService;
	}

	@GetMapping("/addAuditorium")
	public String addAuditoriumView(Model model) {
		model.addAttribute("auditorium", new Auditorium());
		return "add-auditorium";
	}

	// ADD
	@PostMapping("/addAuditorium")
	public String addAuditoriumFromView(@ModelAttribute("auditorium") Auditorium auditorium,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			for (ObjectError error : bindingResult.getAllErrors()) {
				System.out.println(error);
			}
		}
		auditoriumService.addAuditorium(auditorium);
		return "redirect:/addAuditorium";
	}

	// GET_ALL
	@GetMapping("/auditoriums")
	public ModelAndView getAuditoriums(Model model) {
		ModelAndView modelAndView = new ModelAndView("list-auditorium");
		modelAndView.addObject("auditoriums", auditoriumService.findAll());
		return modelAndView;
	}

	// DELETE
	@RequestMapping(value = "/deleteAuditorium", method = RequestMethod.POST, params = { "delete" })
	public String deleteAuditoriumView(@ModelAttribute("auditorium") Auditorium auditorium) {
		auditoriumService.removeAuditorium(auditorium);
		return "redirect:/auditoriums";
	}
}
