package com.wipro.solidproperties;

public class PaymentService {
	
	DigitalPayment PaymentSrvice; //Shared Object

	



	public PaymentService(DigitalPayment paymentSrvice) {
		super();
		PaymentSrvice = paymentSrvice;
	}





	public void pay(double amount) {
		PaymentSrvice.makePayment(amount);
    }

}
