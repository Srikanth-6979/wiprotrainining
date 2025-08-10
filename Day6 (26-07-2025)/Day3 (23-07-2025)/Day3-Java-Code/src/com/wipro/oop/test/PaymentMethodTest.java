package com.wipro.oop.test;

import com.wipro.oop.Gpay;
import com.wipro.oop.PaymentMethod;
import com.wipro.oop.PhonePay;

public class PaymentMethodTest {

	public static void main(String[] args) {
		
		
		PaymentMethod pm = new Gpay();
		pm.Pay(500);
		
		PaymentMethod pm1 = new PhonePay();
		pm1.Pay(700);
		

	}

}
