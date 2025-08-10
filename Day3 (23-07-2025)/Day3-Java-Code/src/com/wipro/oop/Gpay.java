package com.wipro.oop;

public class Gpay implements PaymentMethod {

	@Override
	public void Pay(double amount) {
		System.out.println("Payment done " + amount + "  via GPay.");

	}

}
