package softserve.academy.cinemasoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softserve.academy.cinemasoft.model.Auditorium;
import softserve.academy.cinemasoft.repository.AuditoriumRepository;

import java.util.List;

@Service
public class AuditoriumServiceImpl implements AuditoriumService {

    private AuditoriumRepository auditoriumRepository;

    @Autowired
    public AuditoriumServiceImpl(AuditoriumRepository auditoriumRepository) {
        this.auditoriumRepository = auditoriumRepository;
    }

    @Override
    public Auditorium addAuditorium(Auditorium auditoriumToAdd) {
        return this.auditoriumRepository.save(auditoriumToAdd);
    }

    @Override
    public void removeAuditorium(Auditorium auditorium) {
        auditoriumRepository.delete(auditorium);
    }

    @Override
    public List<Auditorium> findAll() {
        return auditoriumRepository.findAll();
    }
}
