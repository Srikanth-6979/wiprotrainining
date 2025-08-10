package com.wipro.oop.test;

import com.wipro.oop.BankOps;
import com.wipro.oop.Citi;
import com.wipro.oop.Hdfc;

public class BankTest {

	public static void main(String[] args) {
		
		BankOps hdfc = new Hdfc();
        hdfc.deposit(500, "HDFC123");
        hdfc.withdraw(200, "HDFC123");

        BankOps citi = new Citi();
        citi.deposit(1000, "CITI456");
        citi.withdraw(3000, "CITI456");  

        System.out.println("HDFC Balance: " +  hdfc);
        System.out.println("Citi Balance: " + citi);

	}

}
