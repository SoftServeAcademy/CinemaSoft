package softServe.academy.cinemasoft.service;



import softServe.academy.cinemasoft.repository.ScreeningRepository;
import softServe.academy.cinemasoft.model.Screening;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ScreeningService {

    @Autowired
    private ScreeningRepository screeningRepository;

    public Screening addScreening(Screening screening){
    return this.screeningRepository.save(screening);
    }
//    public Screening deleteScreening(Screening screening){
//
//    }
//    public Screening editScreening(Screening screening){
//
//    }



}
