
package softserve.academy.cinemasoft.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;

    @NotNull
    @Size(min = 2, max = 40)
    @Column(nullable = false, unique = true)
    private String title;

    @NotNull
    @Size(min = 2, max = 40)
    @Column(nullable = false)
    private String director;

    @NotNull
    @Size(min = 2, max = 40)
    @Column(nullable = false)
    private String cast;

    @ManyToOne
    private Category category;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "movie", fetch = FetchType.LAZY)
    private List<Comment> comment;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "movie")
    private List<Screening> screenings;

    @Lob
    private byte[] cover;

    @NotNull
    @Size(min = 2, max = 40)
    @Column(nullable = false)
    private String trailer;

    @NotNull
    @Size(min = 2, max = 40)
    @Column(nullable = false)
    private String description;


    @Column(nullable = false)
    @NotNull
    @Min(30)
    @Max(240)
    private int duration;

    @NotNull
    @Min(1)
    @Max(5)
    private double rating;

    public Movie(Integer id, String title, String director, String trailer, String description, int duration,
                  double rating, String cast, byte[] cover) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.trailer = trailer;
        this.description = description;
        this.duration = duration;
        this.rating = rating;
        this.cast = cast;
        this.cover = cover;
        this.comment = new ArrayList<>();
    }

    public Movie() {
    }

    public void addComment(Comment comment) {
        this.comment.add(comment);
    }

}

