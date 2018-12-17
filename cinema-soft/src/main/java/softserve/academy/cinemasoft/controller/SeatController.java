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

import softserve.academy.cinemasoft.model.Seat;
import softserve.academy.cinemasoft.service.SeatService;

@Controller
public class SeatController {

	private SeatService seatService;

	@Autowired
	public SeatController(SeatService seatService) {
		this.seatService = seatService;
	}

	@GetMapping("/addSeat")
	public String addSeatView(Model model) {
		model.addAttribute("seat", new Seat());
		return "addSeat";
	}

	// ADD
	@PostMapping("/addSeat")
	public String addSeatFromView(@ModelAttribute("seat") Seat seat, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			for (ObjectError error : bindingResult.getAllErrors()) {
				System.out.println(error);
			}
		}
		seatService.addSeat(seat);
		return "redirect:/addSeat";
	}

	// GET_ALL
	@GetMapping("/seats")
	public ModelAndView getSeats(Model model) {
		ModelAndView modelAndView = new ModelAndView("list-seats");
		modelAndView.addObject("seats", seatService.findAll());
		return modelAndView;
	}

	// DELETE
	@RequestMapping(value = "/deleteSeat", method = RequestMethod.POST, params = { "delete" })
	public String deleteSeatView(@ModelAttribute("seat") Seat seat) {
		seatService.removeSeat(seat);
		return "redirect:/seats";
	}
}
