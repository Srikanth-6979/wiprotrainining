package com.wipro.paymentsms.service;

import com.wipro.bookingms.dto.PaymentRequest;
import com.wipro.paymentsms.dto.PaymentResponse;
import com.wipro.paymentsms.entity.Payment;
import com.wipro.paymentsms.repo.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PaymentProcessor {

    @Autowired
    private PaymentRepo paymentRepo;

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @KafkaListener(
            topics = "T1",
            groupId = "payment-group",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void consume(PaymentRequest request) {
        System.out.println(" Received PaymentRequest: " + request);
        	
        String status;
        if (request.getCardNumber() != null && request.getCardNumber().length() == 16) {
            status = "SUCCESSFUL";
        } else {
            status = "FAILED";
        }


        Payment payment = Payment.builder()
                .bookingId(request.getBookingId())
                .amount(request.getAmount())
                .mode(request.getMode())
                .status(status)
                .paymentTime(LocalDateTime.now())
                .build();

        paymentRepo.save(payment);
        System.out.println("Saved payment into DB: " + payment);

        PaymentResponse response = new PaymentResponse(
                request.getBookingId(),
                status,
                request.getAmount()
        );

        kafkaTemplate.send("T2", response);
        System.out.println("Sent PaymentResponse to topic T2: " + response);
    }
}
