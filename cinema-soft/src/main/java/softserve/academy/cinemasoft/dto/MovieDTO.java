package softserve.academy.cinemasoft.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class MovieDTO {

	@NotEmpty(message = "Movie title cannot be empty.")
	public String title;
	
	@NotEmpty(message = "Movie's director cannot be empty.")
	private String director;
	
	private List<String> cast;
	
	private byte[] cover;
	
	private String trailer;
	
    @NotEmpty(message = "Movie description cannot be empty.")
    @Size(min=5, max=100, message = "Movie description must be between 5 and 100 symbols long.")
	private String description;
	
	private String duration;
	
	private double rating;
	
}
