package com.wipro.bookingms.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "bookings")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long flightId;
    private String passengerName;
    private String email;
    private Double amount;
    private String cardNumber;

    @Enumerated(EnumType.STRING)
    private PaymentStatus status;

    private LocalDateTime bookingTime;
}
