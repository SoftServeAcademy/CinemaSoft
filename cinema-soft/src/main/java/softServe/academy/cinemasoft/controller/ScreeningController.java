package softServe.academy.cinemasoft.controller;

import softServe.academy.cinemasoft.service.ScreeningService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ScreeningController {

    private ScreeningService screeningService;

    @Autowired
    public ScreeningController(ScreeningService screeningService){
        this.screeningService = screeningService;
    }

    // EDIT SCREENING

    // DELETE SCREENING

    // ADD SCREENING

}
