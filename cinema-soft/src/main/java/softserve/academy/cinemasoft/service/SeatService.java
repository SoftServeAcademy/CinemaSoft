package softserve.academy.cinemasoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import softserve.academy.cinemasoft.model.Seat;
import softserve.academy.cinemasoft.repository.SeatRepository;

@Service
public class SeatService {

	private SeatRepository seatRepository;

	@Autowired
	public SeatService(SeatRepository seatRepository) {
		this.seatRepository = seatRepository;
	}

	public Seat addSeat(Seat seatToAdd) {
		return this.seatRepository.save(seatToAdd);
	}

	public void removeSeat(Seat seatToRemove) {
		seatRepository.delete(seatToRemove);
	}

	public List<Seat> findAll() {
		return seatRepository.findAll();
	}
}
