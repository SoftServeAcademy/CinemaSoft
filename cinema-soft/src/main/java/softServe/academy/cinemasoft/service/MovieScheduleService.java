package softServe.academy.cinemasoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softServe.academy.cinemasoft.model.MovieSchedule;
import softServe.academy.cinemasoft.repository.MovieScheduleRepository;

import java.util.List;

@Service
public class MovieScheduleService {

    private MovieScheduleRepository movieScheduleRepository;

    @Autowired
    public MovieScheduleService(MovieScheduleRepository movieScheduleRepository){
        this.movieScheduleRepository = movieScheduleRepository;
    }

    public void createMovieSchedule(MovieSchedule movieSchedule){
        movieScheduleRepository.save(movieSchedule);
    }

    public void deleteMovieSchedule(MovieSchedule movieSchedule) {
        movieScheduleRepository.delete(movieSchedule);
    }

    public void deleteMovieScheduleById(int id){
        MovieSchedule msid = movieScheduleRepository.getOne(id);
        if (msid != null) {
            this.movieScheduleRepository.delete(msid);
        }
    }

    public List<MovieSchedule> findAll(){
        return movieScheduleRepository.findAll();
    }

    public MovieSchedule getMovieScheduleById(Integer id){
        return movieScheduleRepository.getOne(id);
    }

    public void editMovieSchedule(MovieSchedule movieSchedule) {
        movieScheduleRepository.save(movieSchedule);
    }

}
