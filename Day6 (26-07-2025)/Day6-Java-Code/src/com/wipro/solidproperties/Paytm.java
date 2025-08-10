package com.wipro.solidproperties;

public class Paytm implements DigitalPayment {

	@Override
	public void makePayment(double amount) {

		System.out.println("Payment " + amount + " Done Through Paytm" );
		
	}

}
