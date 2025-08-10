package com.wipro.solidproperties;

public class PhonePe implements DigitalPayment {

	@Override
	public void makePayment(double amount) {
		// TODO Auto-generated method stub

		System.out.println("Payment " + amount + " Done Through PhonePe" );
	}

}
