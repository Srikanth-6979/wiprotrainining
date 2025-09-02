package com.wipro.bookingms.controller;

import com.wipro.bookingms.dto.PaymentRequest;
import com.wipro.bookingms.entity.Booking;
import com.wipro.bookingms.entity.PaymentStatus;
import com.wipro.bookingms.repo.BookingRepository;
import com.wipro.bookingms.service.KafkaProducerService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/booking")
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
    public Booking getOne(@PathVariable Long id) {
        return bookingRepository.findById(id).orElse(null);
    }


    @PostMapping
    public Booking createBooking(@RequestBody Booking booking) {
        booking.setStatus(PaymentStatus.INITIATED);
        String cardNum = booking.getCardNumber();
        if (cardNum != null && cardNum.length() > 4) {
            String masked = "**** **** **** " + cardNum.substring(cardNum.length() - 4);
            booking.setCardNumber(masked);
        }
        return bookingRepository.save(booking);
    }


    @PostMapping("/pay/{id}")
    public void pay(@PathVariable Long id, @RequestBody PaymentRequest req) {
        Booking booking = bookingRepository.findById(id).orElseThrow();

        PaymentRequest pr = new PaymentRequest(
                booking.getId(),
                booking.getAmount(),
                "CARD",
                req.getCardNumber()
        );

        kafkaProducerService.sendPaymentRequest(pr);
    }

    @GetMapping("/searchFlight")
    @CircuitBreaker(name = "flightSearch", fallbackMethod = "fallbackSearchFlight")
    public Object searchFlight(@RequestParam String source,@RequestParam String destination,@RequestParam String date) {

        String url = "http://localhost:9999/flight/search?source=" + source
                + "&destination=" + destination + "&date=" + date;

        return restTemplate.getForObject(url, Object.class);
    }

    public Object fallbackSearchFlight(String source, String destination, String date, Throwable t) {
        return "Flight is currently unavailable. Please try again After Sometime.";
    }
}
