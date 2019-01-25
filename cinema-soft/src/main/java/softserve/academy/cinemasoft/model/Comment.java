package softserve.academy.cinemasoft.model;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

import lombok.Data;

@Data
@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String content;

    @DateTimeFormat(iso = ISO.DATE_TIME)
    private Date dateOfComment;

    @ManyToOne
    private Movie movie;

    @ManyToOne
    @JoinColumn(nullable = false, name = "userId")
    private User user;

    public Comment() {
        this.dateOfComment = new Date();
    }
}


