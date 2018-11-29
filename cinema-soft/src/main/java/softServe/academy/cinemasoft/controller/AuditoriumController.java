package softServe.academy.cinemasoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import softServe.academy.cinemasoft.service.AuditoriumService;

@Controller
public class AuditoriumController {

	@Autowired
	private AuditoriumService auditoriumService;
	
}
