package com.wipro.bookingms.service;

import com.wipro.bookingms.entity.Booking;
import com.wipro.bookingms.entity.PaymentStatus;

public interface BookingService {
    Booking createBooking(Booking booking);
    Booking updateStatus(Long bookingId, PaymentStatus status);
    Booking findById(Long id);
}
