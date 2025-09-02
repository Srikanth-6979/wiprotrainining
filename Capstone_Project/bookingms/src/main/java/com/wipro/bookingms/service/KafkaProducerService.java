package com.wipro.bookingms.service;

import com.wipro.bookingms.dto.PaymentRequest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
    private final KafkaTemplate<String, PaymentRequest> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, PaymentRequest> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendPaymentRequest(PaymentRequest request) {
        kafkaTemplate.send("T1", request);
    }
}
