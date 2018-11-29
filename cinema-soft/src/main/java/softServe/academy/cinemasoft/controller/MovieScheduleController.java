package softServe.academy.cinemasoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import softServe.academy.cinemasoft.entity.MovieSchedule;
import softServe.academy.cinemasoft.service.MovieScheduleService;

import java.util.List;

@RestController
public class MovieScheduleController {

    private MovieScheduleService movieScheduleService;

    @Autowired
    public MovieScheduleController(MovieScheduleService movieScheduleService){
        this.movieScheduleService = movieScheduleService;
    }

    @GetMapping("/movieSchedules")
    public ResponseEntity<List<?>> getAllMovieSchedule() {
        return ResponseEntity.ok(this.movieScheduleService.findAllMovieSchedule());
    }

    @GetMapping("/movieScheduleByName/{name}")
    public ResponseEntity<?> getStudentByName(@PathVariable String name){
        List<MovieSchedule> result = this.movieScheduleService.findByName(name);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/movieSchedule")
    public ResponseEntity<?> createMovieSchedule(@RequestBody MovieSchedule movieSchedule){
        this.movieScheduleService.createMovieSchedule(movieSchedule);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    public void addScreening(){

    }

    public void showWeeklySchedule(){

    }

}
