package softserve.academy.cinemasoft.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

import lombok.Data;

@Data
@Entity
public class Auditorium {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String name;

    private int numberOfRows;

    private int seatsInRow;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "auditorium", fetch = FetchType.LAZY)
    private List<Screening> screenings;


}
