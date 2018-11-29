package softServe.academy.cinemasoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softServe.academy.cinemasoft.entity.MovieSchedule;
import softServe.academy.cinemasoft.repository.MovieScheduleRepository;

import java.util.List;

@Service
public class MovieScheduleService {

    private MovieScheduleRepository movieScheduleRepository;

    @Autowired
    public MovieScheduleService(MovieScheduleRepository movieScheduleRepository){
        this.movieScheduleRepository = movieScheduleRepository;
    }

    public List<MovieSchedule> findByName(String name){
        return movieScheduleRepository.findByName(name);
    }

    public MovieSchedule createMovieSchedule(MovieSchedule movieSchedule){
        return this.movieScheduleRepository.save(movieSchedule);
    }

    public void addScreening() {

    }

    public void showWeekSchedule() {

    }

    public List<?> findAllMovieSchedule() {
        return this.movieScheduleRepository.findAll();

    }

}
