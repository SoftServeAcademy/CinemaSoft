package softServe.academy.cinemasoft.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;

@Entity
public class MovieSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // ? needs to be replaced by Movie
    private List<?> scheduleScreening;
    private Date currentDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<?> getScheduleScreening() {
        return scheduleScreening;
    }

    public void setScheduleScreening(List<?> scheduleScreening) {
        this.scheduleScreening = scheduleScreening;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }
}
