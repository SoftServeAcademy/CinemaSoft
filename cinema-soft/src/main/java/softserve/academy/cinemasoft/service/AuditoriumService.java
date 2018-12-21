package softserve.academy.cinemasoft.service;

import softserve.academy.cinemasoft.model.Auditorium;

import java.util.List;

public interface AuditoriumService {

    Auditorium addAuditorium(Auditorium auditoriumToAdd);

    void removeAuditorium(Auditorium auditorium);

    List<Auditorium> findAll();
}