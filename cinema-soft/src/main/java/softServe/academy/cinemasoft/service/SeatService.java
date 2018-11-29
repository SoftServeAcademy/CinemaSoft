package softServe.academy.cinemasoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import softServe.academy.cinemasoft.entity.Seat;
import softServe.academy.cinemasoft.repository.SeatRepository;

@Service
public class SeatService {

	@Autowired
	private SeatRepository seatRepository;
	
	public Seat addSeat(Seat seatToAdd) {
		return this.seatRepository.save(seatToAdd);
	}
	
}
