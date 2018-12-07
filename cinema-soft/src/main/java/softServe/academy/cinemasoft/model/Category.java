package softServe.academy.cinemasoft.model;


import javax.persistence.*;
import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(unique = true)
    private String nameOfCategory;

    @OneToMany
    @JoinTable(name="categories_movies",
    joinColumns = @JoinColumn(name="category_id"),
            inverseJoinColumns = @JoinColumn(name="movie_id")
    )
    private List<Movie> movies;


    public Category() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameOfCategory() {
        return nameOfCategory;
    }

    public void setNameOfCategory(String nameOfCategory) {
        this.nameOfCategory = nameOfCategory;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
