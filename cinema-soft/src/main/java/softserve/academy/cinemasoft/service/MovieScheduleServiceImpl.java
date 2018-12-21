package softserve.academy.cinemasoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softserve.academy.cinemasoft.model.MovieSchedule;
import softserve.academy.cinemasoft.repository.MovieScheduleRepository;

import java.util.List;

@Service
public class MovieScheduleServiceImpl implements MovieScheduleService {

    private MovieScheduleRepository movieScheduleRepository;

    @Autowired
    public MovieScheduleServiceImpl(MovieScheduleRepository movieScheduleRepository) {
        this.movieScheduleRepository = movieScheduleRepository;
    }

    @Override
    public void createMovieSchedule(MovieSchedule movieSchedule) {
        movieScheduleRepository.save(movieSchedule);
    }

    @Override
    public void deleteMovieSchedule(MovieSchedule movieSchedule) {
        movieScheduleRepository.delete(movieSchedule);
    }

    @Override
    public void deleteMovieScheduleById(int id) {
        MovieSchedule msid = movieScheduleRepository.getOne(id);
        if (msid != null) {
            this.movieScheduleRepository.delete(msid);
        }
    }

    @Override
    public List<MovieSchedule> findAll() {
        return movieScheduleRepository.findAll();
    }

    @Override
    public void editMovieSchedule(MovieSchedule movieSchedule) {
        movieScheduleRepository.save(movieSchedule);
    }

    @Override
    public MovieSchedule findById(int id) {
        return this.movieScheduleRepository.findById(id);
    }
}
