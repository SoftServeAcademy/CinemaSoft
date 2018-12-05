package softServe.academy.cinemasoft.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;


//import javax.persistence.JoinTable;
//import javax.persistence.ManyToOne;
//import javax.persistence.JoinColumn;

@Entity
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;

	String content;
	@DateTimeFormat(iso = ISO.DATE_TIME)
	Date dateOfComment;
//	@OneToMany
//	@JoinTable(name = "movie_comments", 
//			joinColumns = @JoinColumn(name = "movie_id"), 
//			inverseJoinColumns = @JoinColumn(name = "comment_id"))
//	 private Movie movie;
	
	public Comment() {
		this.dateOfComment = new Date();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDateOfComment() {
		return dateOfComment;
	}

	public void setDateOfComment(Date dateOfComment) {
		this.dateOfComment = dateOfComment;
	}

//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}
//
//	public Movie getMovie() {
//		return movie;
//	}
//
//	public void setMovie(Movie movie) {
//		this.movie = movie;
//	}

}
