package softserve.academy.cinemasoft.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

@Data
@Entity
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "seat_id")
    private Integer id;
    private double seatPrice;
    private boolean isReserved;
    private int atRow;
    private int numberInRow;

    @ManyToOne
    @JoinTable(name = "SEATS_AUDITORIUM",
            joinColumns = @JoinColumn(name = "seat_id"),
            inverseJoinColumns = @JoinColumn(name = "auditorium_id"))
    private Auditorium auditorium;

    public Seat() {

    }

    public Seat(Integer id, double seatPrice, boolean isReserved, int atRow, int numberInRow, Auditorium auditorium) {
        super();
        this.id = id;
        this.seatPrice = seatPrice;
        this.isReserved = isReserved;
        this.atRow = atRow;
        this.numberInRow = numberInRow;
        this.auditorium = auditorium;
    }


}
