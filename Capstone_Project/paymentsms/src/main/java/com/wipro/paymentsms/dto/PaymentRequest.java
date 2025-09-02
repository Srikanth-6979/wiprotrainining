package com.wipro.paymentsms.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentRequest{
    private Long bookingId;
    private Double amount;
    private String mode;
    private String cardNumber;
}
