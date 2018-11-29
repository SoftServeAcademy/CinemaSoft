package softServe.academy.cinemasoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import softServe.academy.cinemasoft.service.SeatService;


@Controller
public class SeatController {

	@Autowired
	private SeatService seatService;
}
