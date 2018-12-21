package softserve.academy.cinemasoft.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
@Table(name = "screening")
public class Screening {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer Id;

    @NotNull
    @Size(min = 5, max = 5)
    private String startTime;

    @ManyToOne
    @JoinTable(name = "SCREENING_AUDITORIUM",
            joinColumns = @JoinColumn(name = "screening_id"),
            inverseJoinColumns = @JoinColumn(name = "auditorium_id"))
    private Auditorium auditorium;

    @ManyToOne

    private Movie movie;

    public Screening() {

    }

    public Screening(String startTime) {
        this.startTime = startTime;
    }

}
