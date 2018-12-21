package softserve.academy.cinemasoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softserve.academy.cinemasoft.model.Seat;
import softserve.academy.cinemasoft.repository.SeatRepository;

import java.util.List;

@Service
public class SeatServiceImpl implements SeatService {

    private SeatRepository seatRepository;

    @Autowired
    public SeatServiceImpl(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    @Override
    public Seat addSeat(Seat seatToAdd) {
        return this.seatRepository.save(seatToAdd);
    }

    @Override
    public void removeSeat(Seat seatToRemove) {
        seatRepository.delete(seatToRemove);
    }

    @Override
    public List<Seat> findAll() {
        return seatRepository.findAll();
    }
}
