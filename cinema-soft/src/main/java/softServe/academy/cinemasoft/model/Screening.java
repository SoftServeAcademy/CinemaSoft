package softServe.academy.cinemasoft.model;

import javax.persistence.*;

@Entity
@Table(name = "screening")
public class Screening {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;
    @Column(unique = true)
    String startTime;

    // to be added
    //    Movie movieToProject;
    //    Auditorium auditorium;

//    @ManyToOne
//    private Movie movie;

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

//    public void setMovie() {
//        this.movie = movie;
//    }
//
//    public Movie getMovie(){
//        return movie;
//    }

}
