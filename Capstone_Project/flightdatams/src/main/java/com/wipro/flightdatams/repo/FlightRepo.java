package com.wipro.flightdatams.repo;

import com.wipro.flightdatams.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FlightRepo extends JpaRepository<Flight, Long> {
    List<Flight> findBySourceAndDestinationAndValidFromLessThanEqualAndValidToGreaterThanEqual(
            String source, String destination, LocalDate from, LocalDate to);
}
