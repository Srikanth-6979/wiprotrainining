package com.wipro.solidproperties;

public class DigitalPaymentTest {

	public static void main(String[] args) {


		DigitalPayment dgp = new GooglePay();     
		PaymentService ps = new PaymentService(dgp); 
		ps.pay(500.0);
		
		DigitalPayment dpp = new PhonePe();     
		PaymentService ps1 = new PaymentService(dpp); 
		ps.pay(500.0);
		
		DigitalPayment dp = new Paytm();     
		PaymentService ps2 = new PaymentService(dp); 
		ps.pay(500.0);
		
	}

}
