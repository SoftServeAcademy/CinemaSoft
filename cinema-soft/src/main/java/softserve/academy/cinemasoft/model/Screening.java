package softserve.academy.cinemasoft.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "screening")
public class Screening {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer Id;

    @NotNull
    @Size(min=5, max=5)
    private String startTime;

    @ManyToOne
    @JoinTable(name = "SCREENING_AUDITORIUM",
            joinColumns = @JoinColumn(name = "screening_id"),
            inverseJoinColumns = @JoinColumn(name = "auditorium_id"))
    private Auditorium auditorium;

    @ManyToOne

    private Movie movie;

    public Screening(){

    }

    public Screening(String startTime){
        this.startTime = startTime;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        this.Id = id;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
///
    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Movie getMovie(){
        return movie;
    }
//
    public void setAuditorium(Auditorium auditorium) {
        this.auditorium = auditorium;
    }

    public Auditorium getAuditorium(){
        return auditorium;
    }
///
}
