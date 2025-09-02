package com.wipro.paymentsms.service.impl;
//
//import com.wipro.paymentsms.entity.Payment;
//import com.wipro.paymentsms.repo.PaymentRepo;
//import com.wipro.paymentsms.service.PaymentService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//import java.util.HashMap;
//import java.util.Map;
//
//@Service
//public class PaymentServiceImpl implements PaymentService {
//
//    @Autowired
//    private PaymentRepo repo;
//
//    @Override
//    public Map<String, Object> processPayment(Map<String, Object> payload) {
//        Long bookingId = Long.valueOf(payload.get("bookingId").toString());
//        Double amount = Double.valueOf(payload.get("amount").toString());
//        String mode = payload.get("mode") != null ? payload.get("mode").toString() : "CARD";
//
//        boolean success = Math.random() > 0.2; // 80% success
//        String status = success ? "SUCCESS" : "FAILED";
//
//        Payment payment = Payment.builder()
//                .bookingId(bookingId)
//                .amount(amount)
//                .mode(mode)
//                .status(status)
//                .paymentTime(LocalDateTime.now())
//                .build();
//        repo.save(payment);
//
//        
//        Map<String,Object> result = new HashMap<>();
//        result.put("bookingId", bookingId);
//        result.put("status", status);
//        result.put("amount", amount);
//
//        return result;
//    }
//}
