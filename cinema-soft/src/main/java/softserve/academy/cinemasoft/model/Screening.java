package softserve.academy.cinemasoft.model;

import lombok.Data;
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

@Entity
@Data
@Table(name = "screening")
public class Screening {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer Id;

    @NotNull
    @Size(min = 4, max = 5)
    @Column(nullable = false)
    private String startTime;


    @ManyToOne
    private Auditorium auditorium;

    @ManyToOne
    private Movie movie;

    @Enumerated(EnumType.STRING)
    private DaysOfWeek dayOfWeek;


}
