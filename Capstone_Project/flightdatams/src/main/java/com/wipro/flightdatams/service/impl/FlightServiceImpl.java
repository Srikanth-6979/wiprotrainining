package com.wipro.flightdatams.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.flightdatams.entity.Flight;
import com.wipro.flightdatams.repo.FlightRepo;
import com.wipro.flightdatams.service.FlightService;

import java.time.LocalDate;
import java.util.List;

@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    private FlightRepo repo;

    @Override
    public Flight saveFlight(Flight flight) {
        return repo.save(flight);
    }

    @Override
    public List<Flight> getAllFlights() {
        return repo.findAll();
    }

    @Override
    public Flight getFlightById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Flight> searchFlights(String source, String destination, String date) {
        LocalDate d = LocalDate.parse(date);
        return repo.findBySourceAndDestinationAndValidFromLessThanEqualAndValidToGreaterThanEqual(
                source, destination, d, d);
    }
}
