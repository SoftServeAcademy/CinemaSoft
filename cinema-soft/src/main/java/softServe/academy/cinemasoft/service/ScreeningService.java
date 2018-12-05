package softServe.academy.cinemasoft.service;

import softServe.academy.cinemasoft.repository.ScreeningRepository;
import softServe.academy.cinemasoft.model.Screening;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ScreeningService {

    private ScreeningRepository screeningRepository;

    @Autowired
    public ScreeningService(ScreeningRepository screeningRepository){
        this.screeningRepository = screeningRepository;
    }

    public List<Screening> findAllScreenings(){
        return this.screeningRepository.findAll();
    }


    public Screening addScreening(Screening screening){
    return this.screeningRepository.save(screening);
    }

    void deleteScreening(Screening screening){
        this.screeningRepository.delete(screening);
    }

//    public Screening getScreeningById(int id) {
//        return ScreeningRepository.getOne(id);
//    }

    // EDIT SCREENING




}
