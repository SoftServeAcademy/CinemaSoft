package softServe.academy.cinemasoft.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="movie")
public class Movie {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    public Integer id;

    @Column(nullable = false, unique = true)
    public String title;
    

    @Column(nullable = false)
    public String director;
    

//    @Column(nullable = false)
//    @ElementCollection(targetClass=String.class)
//    public byte[] cast;
    

    @Column(nullable = false)
    public String trailer;
    
    @Column(nullable = false)
    public String description;
    
    @Column(nullable = false)
    public String duration;
   
    @Column
    public double rating;
    
    /*
     *  @Column
    @OneToMany(mappedBy = "category")
    private List<Category> categories;
    */
    
    
    
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
