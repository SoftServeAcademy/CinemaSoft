package softServe.academy.cinemasoft.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

@Entity
public class Seat {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
private int rowNumber;
private int seatInRowNumber;
//private double seatPrice;????

@ManyToOne
private Auditorium auditorium;

public int getRowNumber() {
	return rowNumber;
}
public void setRowNumber(int rowNumber) {
	this.rowNumber = rowNumber;
}
public int getSeatInRowNumber() {
	return seatInRowNumber;
}
public void setSeatInRowNumber(int seatInRowNumber) {
	this.seatInRowNumber = seatInRowNumber;
}


}
