package softserve.academy.cinemasoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import softserve.academy.cinemasoft.model.Seat;

public interface SeatRepository extends JpaRepository<Seat,Integer>{

}
