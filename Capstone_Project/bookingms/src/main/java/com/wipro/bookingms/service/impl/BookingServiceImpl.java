package com.wipro.bookingms.service.impl;

import org.springframework.stereotype.Service;

import com.wipro.bookingms.entity.Booking;
import com.wipro.bookingms.entity.PaymentStatus;
import com.wipro.bookingms.repo.BookingRepository;
import com.wipro.bookingms.service.BookingService;



@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository repo;

    public BookingServiceImpl(BookingRepository repo) {
        this.repo = repo;
    }

    @Override
    public Booking createBooking(Booking booking) {

        booking.setStatus(PaymentStatus.INITIATED);
        String cardNum = booking.getCardNumber();
        if (cardNum != null && cardNum.length() > 4) {
            booking.setCardNumber("**** **** **** " + cardNum.substring(cardNum.length() - 4));
        }
        return repo.save(booking);
    }

    @Override
    public Booking updateStatus(Long bookingId, PaymentStatus status) {
        Booking b= repo.findById(bookingId).orElseThrow(() -> new RuntimeException("Booking not found: " + bookingId));
        b.setStatus(status);
        return repo.save(b);
    }

    @Override
    public Booking findById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Booking not found: " + id));
    }
}
