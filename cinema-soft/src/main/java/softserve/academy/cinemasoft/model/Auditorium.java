package softserve.academy.cinemasoft.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Auditorium {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "auditorium_id")
    private Integer id;

    @Column
    private String name;

    private int numberOfRows;

    private int seatsInRow;

    @OneToMany(mappedBy = "auditorium")
    private List<Seat> seats;

    @OneToMany
    private List<Screening> screening;

    public Auditorium(Integer id, String name, int numberOfRows, int seatsInRow, List<Seat> seats) {
        super();
        this.id = id;
        this.name = name;
        this.numberOfRows = numberOfRows;
        this.seatsInRow = seatsInRow;
        this.seats = seats;
    }

}
