package com.wipro.bookingms.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.bookingms.entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
}
