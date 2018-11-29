package softServe.academy.cinemasoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import softServe.academy.cinemasoft.entity.Auditorium;
import softServe.academy.cinemasoft.repository.AuditoriumRepository;

@Service
public class AuditoriumService {
	@Autowired
	private AuditoriumRepository auditoriumRepository;

	public Auditorium addAuditorium(Auditorium auditoriumToAdd) {
		return this.auditoriumRepository.save(auditoriumToAdd);
	}
	
	
	
}
