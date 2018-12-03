package softServe.academy.cinemasoft.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import softServe.academy.cinemasoft.model.Screening;
import softServe.academy.cinemasoft.service.ScreeningService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

import static com.sun.deploy.trace.Trace.flush;
import static org.springframework.transaction.support.TransactionSynchronizationManager.clear;

@Controller
public class ScreeningController {

    private ScreeningService screeningService;

    @Autowired
    public ScreeningController(ScreeningService screeningService){
        this.screeningService = screeningService;
    }

    // EDIT SCREENING

    // DELETE SCREENING

//    @GetMapping("/screening/{id}")
//    public ResponseEntity<?> getScreeningById(@PathVariable int id){
//        Screening result = this.screeningService.getScreeningById(id);
//        if (result != null){
//            return ResponseEntity.status(HttpStatus.CREATED).build();
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }

    @GetMapping("/screening")
    public ResponseEntity<List<Screening>> getAllScreenings(){
        return ResponseEntity.ok(this.screeningService.findAllScreenings());
    }

//    @RequestMapping("/remove/{id}")
//    public ResponseEntity<?> deleteScreeningById(@PathVariable int id) {
//        Screening screening = new Screening();
//        screening.setId(id);
//        entityManager.persist(screening);
//        flushAndClear();
//        screening = entityManager.find(Screening.class, screening.getId());
//        assertThat(screening, notNullValue());
//        entityManager.remove(foo);
//        flushAndClear();
//        assertThat(entityManager.find(Screening.class, screening.getId()), nullValue());
//    }

//    @RequestMapping(value ="/screening/remove/{id}")
//    public String deleteScreening(@PathVariable("id") int Id){
//        screeningService.delete(id);
//        return "redirect:/screening";
//    }
//
//    // ADD SCREENING
//
//    private void flushAndClear() {
//        flush();
//        clear();
//    }


}
