package softserve.academy.cinemasoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import softserve.academy.cinemasoft.model.Auditorium;
import softserve.academy.cinemasoft.repository.AuditoriumRepository;

@Service
public class AuditoriumService {

	private AuditoriumRepository auditoriumRepository;

	@Autowired
	public AuditoriumService(AuditoriumRepository auditoriumRepository) {
		this.auditoriumRepository = auditoriumRepository;
	}

	public Auditorium addAuditorium(Auditorium auditoriumToAdd) {
		return this.auditoriumRepository.save(auditoriumToAdd);
	}

	public void removeAuditorium(Auditorium auditorium) {
		auditoriumRepository.delete(auditorium);
	}

	public List<Auditorium> findAll() {
		return auditoriumRepository.findAll();
	}
}
