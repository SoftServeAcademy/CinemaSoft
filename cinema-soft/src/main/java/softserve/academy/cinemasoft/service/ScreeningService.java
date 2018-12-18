package softserve.academy.cinemasoft.service;

import softserve.academy.cinemasoft.repository.ScreeningRepository;
import softserve.academy.cinemasoft.model.Screening;

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
        Screening screening1 = new Screening();
        screening1.setStartTime(screening.getStartTime());
        return this.screeningRepository.save(screening1);
    }

    public void deleteScreening(int id){
        Screening s = screeningRepository.getOne(id);
        if (s != null) {
            this.screeningRepository.delete(s);
        }
    }

    public boolean isValid(String string){
            if (!string.contains(":")){
                return false;
            }
            String[] array = string.split(":");
            int hours = Integer.parseInt(array[0]);
            int minutes = Integer.parseInt(array[1]);

            return  (0 <= hours && hours < 24 && minutes >= 0 && minutes <= 59);
    }

    public void createScreening(Screening screening){
        screeningRepository.save(screening);
    }

    public void editPostScreening(Screening screening) {
        screeningRepository.save(screening);
    }

    public Screening findById(int id){
       return this.screeningRepository.findById(id);
    }

}
