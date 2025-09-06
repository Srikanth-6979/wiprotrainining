package com.wipro.bookingms.controller;

import com.wipro.bookingms.dto.PaymentRequest;
import com.wipro.bookingms.entity.Booking;
import com.wipro.bookingms.entity.PaymentStatus;
import com.wipro.bookingms.repo.BookingRepository;
import com.wipro.bookingms.service.KafkaProducerService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/booking")
@CrossOrigin(origins = "http://localhost:4200")
public class BookingController {

    private final BookingRepository bookingRepository;
    private final KafkaProducerService kafkaProducerService;
    private final RestTemplate restTemplate;

    public BookingController(
            BookingRepository bookingRepository,
            KafkaProducerService kafkaProducerService,
            RestTemplate restTemplate
    ) {
        this.bookingRepository = bookingRepository;
        this.kafkaProducerService = kafkaProducerService;
        this.restTemplate = restTemplate;
    }

    @GetMapping("/all")
    public List<Booking> getAll() {
        return bookingRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Booking> getOne(@PathVariable Long id) {
        return bookingRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
        try {
            // Set initial status and booking time
            booking.setStatus(PaymentStatus.INITIATED);
            booking.setBookingTime(LocalDateTime.now());

            // Mask card number
            String cardNum = booking.getCardNumber();
            if (cardNum != null && cardNum.length() > 4) {
                String masked = "**** **** **** " + cardNum.substring(cardNum.length() - 4);
                booking.setCardNumber(masked);
            }

            Booking savedBooking = bookingRepository.save(booking);
            return ResponseEntity.ok(savedBooking);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping("/pay/{id}")
    public ResponseEntity<Void> pay(@PathVariable Long id, @RequestBody PaymentRequest req) {
        try {
            Booking booking = bookingRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Booking not found"));

            PaymentRequest pr = new PaymentRequest(
                    booking.getId(),
                    booking.getAmount(),
                    "CARD",
                    req.getCardNumber()
            );

            kafkaProducerService.sendPaymentRequest(pr);
            return ResponseEntity.ok().build();

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/searchFlight")
    @CircuitBreaker(name = "flightSearch", fallbackMethod = "fallbackSearchFlight")
    public ResponseEntity<Object> searchFlight(
            @RequestParam String source,
            @RequestParam String destination,
            @RequestParam String date) {

        try {
            String url = "http://localhost:9999/flight/search?source=" + source
                    + "&destination=" + destination + "&date=" + date;

            Object flights = restTemplate.getForObject(url, Object.class);
            return ResponseEntity.ok(flights);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                    .body("Flight search service unavailable. Please try again later.");
        }
    }

    public ResponseEntity<String> fallbackSearchFlight(String source, String destination, String date, Throwable t) {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .body("Flight is currently unavailable. Please try again later.");
    }
}
