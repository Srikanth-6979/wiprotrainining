package com.wipro.paymentsms.controller;

import com.wipro.paymentsms.entity.Payment;
import com.wipro.paymentsms.repo.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentRepo repo;

    @GetMapping("/all")
    public List<Payment> all() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Payment byId(@PathVariable Long id) {
        return repo.findById(id).orElse(null);
    }
}
