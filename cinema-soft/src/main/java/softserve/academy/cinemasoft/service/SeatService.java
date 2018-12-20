package softserve.academy.cinemasoft.service;

import softserve.academy.cinemasoft.model.Seat;

import java.util.List;

public interface SeatService {

    Seat addSeat(Seat seatToAdd);

    void removeSeat(Seat seatToRemove);

    List<Seat> findAll();
}
