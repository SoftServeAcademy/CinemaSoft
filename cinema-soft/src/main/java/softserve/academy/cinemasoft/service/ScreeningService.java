package softserve.academy.cinemasoft.service;

import softserve.academy.cinemasoft.repository.ScreeningRepository;
import softserve.academy.cinemasoft.model.Screening;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Service
public class ScreeningService {

    private ScreeningRepository screeningRepository;

    private static final String regex = "([01]?[0-9]|2[0-3]):[0-5][0-9]";

    private Pattern pattern;

    private Matcher matcher;

    @Autowired
    public ScreeningService(ScreeningRepository screeningRepository){
        this.screeningRepository = screeningRepository;
        pattern = Pattern.compile(regex);
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
        matcher = pattern.matcher(string);
        return matcher.matches();
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
