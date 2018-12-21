package softserve.academy.cinemasoft.service;

import softserve.academy.cinemasoft.model.MovieSchedule;

import java.util.List;

public interface MovieScheduleService {

    void createMovieSchedule(MovieSchedule movieSchedule);

    void deleteMovieSchedule(MovieSchedule movieSchedule);

    void deleteMovieScheduleById(int id);

    List<MovieSchedule> findAll();

    void editMovieSchedule(MovieSchedule movieSchedule);

    MovieSchedule findById(int id);
}
