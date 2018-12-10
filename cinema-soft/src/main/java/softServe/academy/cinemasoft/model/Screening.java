package softServe.academy.cinemasoft.model;

import javax.persistence.*;

@Entity
@Table(name = "screening")
public class Screening {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer Id;
    private String startTime;

    @ManyToOne
    @JoinTable(name = "SCREENING_AUDITORIUM",
            joinColumns = @JoinColumn(name = "screening_id"),
            inverseJoinColumns = @JoinColumn(name = "auditorium_id"))
    Auditorium auditorium;
//
    @ManyToOne
    @JoinTable(name = "SCREENING_MOVIE",
            joinColumns = @JoinColumn(name = "screening_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id"))
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
    public void setMovieProjection(Movie moviet) {
        this.movie = movie;
    }

    public Movie getMovieProjection(){
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
