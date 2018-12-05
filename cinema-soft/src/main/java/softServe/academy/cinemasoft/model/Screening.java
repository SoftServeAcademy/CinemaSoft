package softServe.academy.cinemasoft.model;

import javax.persistence.*;

@Entity
@Table(name = "screening")
public class Screening {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;
    private String startTime;

    // to be added
    //    Auditorium auditorium;
    //    @ManyToOne
    //    Movie movieToProject;

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

//    public void setMovieProjection(Movie movieToProject) {
//        this.movieToProject = movieToProject;
//    }
//
//    public Movie getMovieProjection(){
//        return movieToProject;
//    }

}
