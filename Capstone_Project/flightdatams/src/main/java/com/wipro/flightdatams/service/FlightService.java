package com.wipro.flightdatams.service;

import com.wipro.flightdatams.entity.Flight;
import java.util.List;

public interface FlightService {
    Flight saveFlight(Flight flight);
    List<Flight> getAllFlights();
    Flight getFlightById(Long id);
    List<Flight> searchFlights(String source, String destination, String date);
}
