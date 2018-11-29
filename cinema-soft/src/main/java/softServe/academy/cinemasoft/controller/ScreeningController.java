package softServe.academy.cinemasoft.controller;

import org.springframework.http.HttpStatus;
import softServe.academy.cinemasoft.model.Screening;
import softServe.academy.cinemasoft.service.ScreeningService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
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
