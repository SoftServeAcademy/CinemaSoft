package softserve.academy.cinemasoft.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(unique = true)
    private String nameOfCategory;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category", fetch = FetchType.LAZY)
    private List<Movie> movies;

    public Category() {
    }

    public Category(String nameOfCategory) {
        this.nameOfCategory = nameOfCategory;
    }



}
