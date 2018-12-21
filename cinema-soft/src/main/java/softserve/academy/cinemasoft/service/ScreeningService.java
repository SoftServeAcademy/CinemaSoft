package softserve.academy.cinemasoft.service;

import softserve.academy.cinemasoft.model.Screening;

import java.util.List;

public interface ScreeningService  {

    List<Screening> findAllScreenings();

    Screening addScreening(Screening screening);

    void deleteScreening(int id);

    void createScreening(Screening screening);

    void editPostScreening(Screening screening);

    Screening findById(int id);

    boolean isValid(String time);
}
