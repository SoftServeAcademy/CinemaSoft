package softServe.academy.cinemasoft.model;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Category {

    @Id
    private Integer id;
    private String nameOfCategory;

    //private List<Movie> movies;


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
}
