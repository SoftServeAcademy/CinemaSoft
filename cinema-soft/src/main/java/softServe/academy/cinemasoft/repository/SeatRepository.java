package softServe.academy.cinemasoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import softServe.academy.cinemasoft.entity.Seat;

public interface SeatRepository extends JpaRepository<Seat,Integer>{

}
