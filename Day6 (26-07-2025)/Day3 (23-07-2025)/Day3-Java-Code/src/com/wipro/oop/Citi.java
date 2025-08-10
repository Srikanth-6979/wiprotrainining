package com.wipro.oop;

public class Citi implements BankOps {
	
	double balance = 2000.0;

	@Override
	public void deposit(double amount, String accNumber) {
	    System.out.println("Citi: Deposited " + amount + " to account " + accNumber);
	}

	@Override
	public double withdraw(double amount, String accNumber) {
		
	    System.out.println("Citi: Withdrawn " + amount + " from account " + accNumber);
	    return amount;
	}
	

}