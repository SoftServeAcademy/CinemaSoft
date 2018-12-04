package softServe.academy.cinemasoft.model;

import javax.persistence.*;

@Entity
public class MovieSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String movieName;
    private String hours;

    public MovieSchedule() {
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
