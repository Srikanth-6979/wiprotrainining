package com.wipro.oop;

public class PhonePay implements PaymentMethod {

	@Override
	public void Pay(double amount) {
		System.out.println("Payment done " + amount + " via PhonePay.");
	}

}
