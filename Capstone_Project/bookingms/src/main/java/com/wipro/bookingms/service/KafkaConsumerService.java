package com.wipro.bookingms.service;

import com.wipro.bookingms.dto.PaymentResponse;
import com.wipro.bookingms.entity.PaymentStatus;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    private final BookingService bookingService;

    public KafkaConsumerService(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @KafkaListener(
            topics = "T2",
            groupId = "booking-service-group",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void consumePaymentResponse(PaymentResponse response) {
        System.out.println("Received PaymentResponse from Kafka: " + response);
        bookingService.updateStatus(
                response.getBookingId(),
                PaymentStatus.valueOf(response.getStatus())
        );
    }
}
