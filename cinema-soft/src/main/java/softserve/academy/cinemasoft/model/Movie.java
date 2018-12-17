
package softserve.academy.cinemasoft.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import java.util.ArrayList;
import java.util.List;



@Entity
@Table(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;

    @NotNull
    @Size(min=2, max=40)
    @Column(nullable = false, unique = true)
    private String title;

    @NotNull
    @Size(min=2, max=40)
    @Column(nullable = false)
    private String director;

    @NotNull
    @Size(min=2, max=40)
    @Column(nullable = false)
    private String cast;

    @ManyToOne
    private Category category;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "movie", fetch = FetchType.LAZY)
    private List<Comment> comment;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "movie")
    private List<Screening> screenings;

    @Lob
    private byte[] cover;

    @NotNull
    @Size(min=2, max=40)
    @Column(nullable = false)
    private String trailer;

    @NotNull
    @Size(min=2, max=40)
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getDiscription() {
        return description;
    }

    public void setDiscription(String discription) {
        this.description = discription;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getCover() {
        return cover;
    }

    public void setCover(byte[] cover) {
        this.cover = cover;
    }

    public List<Comment> getComment() {
        return comment;
    }

    public void setComment(List<Comment> comment) {
        this.comment = comment;
    }

    public List<Screening> getScreenings() {
        return screenings;
    }

    public void setScreenings(List<Screening> screenings) {
        this.screenings = screenings;
    }

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

