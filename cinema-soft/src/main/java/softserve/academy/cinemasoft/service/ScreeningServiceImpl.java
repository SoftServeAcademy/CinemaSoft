package softserve.academy.cinemasoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softserve.academy.cinemasoft.model.Screening;
import softserve.academy.cinemasoft.repository.ScreeningRepository;
import softserve.academy.cinemasoft.utils.Validator;

import java.util.List;


@Service
public class ScreeningServiceImpl implements ScreeningService {

    private ScreeningRepository screeningRepository;
    private Validator validator;

    @Autowired
    public ScreeningServiceImpl(ScreeningRepository screeningRepository, Validator validator) {
        this.screeningRepository = screeningRepository;
        this.validator = validator;
    }

    @Override
    public List<Screening> findAllScreenings() {
        return this.screeningRepository.findAll();
    }

    @Override
    public Screening addScreening(Screening screening) {
        Screening screening1 = new Screening();
        screening1.setStartTime(screening.getStartTime());
        return this.screeningRepository.save(screening1);
    }

    @Override
    public void deleteScreening(int id) {
       screeningRepository.deleteById(id);
    }

    @Override
    public void createScreening(Screening screening) {
        screeningRepository.save(screening);
    }

    @Override
    public void editPostScreening(Screening screening) {
        screeningRepository.save(screening);
    }

    @Override
    public Screening findById(int id) {
        return this.screeningRepository.findById(id);
    }

    @Override
    public boolean isValid(String time) {
        return validator.isValid(time);
    }


}
