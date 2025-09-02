package com.wipro.flightdatams.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.wipro.flightdatams.entity.Flight;
import com.wipro.flightdatams.service.FlightService;

import java.util.List;

@RestController
@RequestMapping("/flight")

public class FlightController {

    @Autowired
    private FlightService service;

    @GetMapping
    public List<Flight> getAll() {
        return service.getAllFlights();
    }

    @GetMapping("/{id}")
    public Flight getById(@PathVariable Long id) {
        return service.getFlightById(id);
    }
    @GetMapping("/search")
    public List<Flight> searchFlights(@RequestParam String source,@RequestParam String destination,@RequestParam String date) {
        return service.searchFlights(source, destination, date);
    }

    @PostMapping
    public Flight addFlight(@RequestBody Flight f) {
        return service.saveFlight(f);
    }

   
}
