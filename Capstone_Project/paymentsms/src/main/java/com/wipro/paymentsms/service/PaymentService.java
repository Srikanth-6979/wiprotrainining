package com.wipro.paymentsms.service;

import java.util.Map;

public interface PaymentService {
    Map<String,Object> processPayment(Map<String,Object> payload);
}
