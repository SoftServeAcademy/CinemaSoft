package softserve.academy.cinemasoft.model;

import softserve.academy.cinemasoft.enums.DaysOfWeek;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

import java.time.DayOfWeek;

@Entity
@Data
@Table(name = "screening")
public class Screening {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Size(min = 4, max = 5)
    @Column(nullable = false)
    private String startTime;


    @ManyToOne
    private Auditorium auditorium;

    @ManyToOne
    private Movie movie;

    @Enumerated
    private DayOfWeek dayOfWeek;

    @Override
    public String toString() {
        return this.id.toString();
    }
}
