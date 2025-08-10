package com.wipro.solidproperties;

public class GooglePay implements DigitalPayment {

	@Override
	public void makePayment(double amount) {
		// TODO Auto-generated method stub
		
		System.out.println("Payment " + amount + " Done Through GooglePay" );
	}

}
