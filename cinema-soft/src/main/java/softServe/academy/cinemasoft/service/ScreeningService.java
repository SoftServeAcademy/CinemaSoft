package softServe.academy.cinemasoft.service;

import org.springframework.http.ResponseEntity;
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

    public void deleteScreening(int id){
        Screening s = screeningRepository.getOne(id);
        if (s != null) {
            this.screeningRepository.delete(s);
        }
    }

    public Screening getScreeningById(int id) {
        return screeningRepository.getOne(id);
    }

    public void createScreening(Screening screening){
        screeningRepository.save(screening);
    }

    public void editScreening(int id, String startTime){
        Screening s = screeningRepository.getOne(id);
        if (s != null){
            String st = startTime;
            s.setStartTime(st);
            screeningRepository.save(s);
        }
    }




}
