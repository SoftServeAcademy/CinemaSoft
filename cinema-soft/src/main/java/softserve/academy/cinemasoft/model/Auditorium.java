package softserve.academy.cinemasoft.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

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
