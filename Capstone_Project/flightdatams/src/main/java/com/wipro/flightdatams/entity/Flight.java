package com.wipro.flightdatams.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String flightNumber;
    private String source;
    private String destination;
    private String aircraftName;
    private Double price;
    private String airline;
    private LocalDate validFrom;
    private LocalDate validTo;
    private LocalTime departureTime; 
    private LocalTime arrivalTime;
}
