package com.wipro.oop;

public class Hdfc implements BankOps {
	
	double balance = 1000.0;

	@Override
	public void deposit(double amount, String accNumber) {
		
	    System.out.println("HDFC: Deposited " + amount + " to account " + accNumber);

	}

	@Override
	public double withdraw(double amount, String accNumber) {
		
	    System.out.println("HDFC: Withdrawn " + amount + " from account " + accNumber);
	    return amount;
	
	}


}