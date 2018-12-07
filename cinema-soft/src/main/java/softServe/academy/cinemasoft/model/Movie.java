package softServe.academy.cinemasoft.model;

import org.springframework.beans.factory.annotation.Autowired;
import softServe.academy.cinemasoft.repository.CategoryRepository;

import javax.persistence.*;


@Entity
@Table(name="movie")
public class Movie {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String title;
    

    @Column(nullable = false)
    private String director;

    @Column(nullable = false)
    private String cast;



    @Column(nullable = false)
//    @ElementCollection(targetClass=String.class)
    private byte[] cover;



	@Column(nullable = false)
    private String trailer;
    
    @Column(nullable = false)
    private String description;
    
    @Column(nullable = false)
    private String duration;
   
    @Column
    private double rating;


    
    /*
     *  @Column
    @OneToMany(mappedBy = "category")
    private List<Category> categories;
    */

    @OneToOne
    private Category category;

/*
     *  @Column
    @OneToMany(mappedBy = "comment")
    private List<Comment> comments;
    */


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

//	public List<String> getCast() {
//		return cast;
//	}
//
//	public void setCast(List<String> cast) {
//		this.cast = cast;
//	}

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

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
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


    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

	public Movie(Integer id, String title, String director, String trailer, String description, String duration,
			double rating) {
		this.id = id;
		this.title = title;
		this.director = director;
		this.trailer = trailer;
		this.description = description;
		this.duration = duration;
		this.rating = rating;
	}

	public Movie() {
	}
}
