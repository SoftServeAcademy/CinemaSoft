package softServe.academy.cinemasoft.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Auditorium {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private int numberOfRows;
	private int seatsInRow;

	@OneToMany
	private List<Seat> seats;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Seat> getSeats() {
		return this.seats;
	}

	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}

	public int getNumberOfRows() {
		return this.numberOfRows;
	}

	public void setNumberOfRows(int numberOfRows) {
		this.numberOfRows = numberOfRows;
	}

	public int getSeatsInRow() {
		return this.seatsInRow;
	}

	public void setSeatsInRow(int seatsInRow) {
		this.seatsInRow = seatsInRow;
	}

	

}
