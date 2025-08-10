package com.wipro.exception;

import java.util.Scanner;

public class ChangeCurrency {
	
	public static int changeCurrency(int number) throws NumberFormatException {
        if (number == 0) {
            throw new NumberFormatException("Invalid Number");
        }
        return number * 80;
    }

    public static void main(String[] args) {
    	
    	//Scanner sc =- new Scanner(System.in);
    	
        try {
            int result = changeCurrency(2);  
            System.out.println("Converted Amount: " + result);
        } catch (NumberFormatException e) {
            System.out.println("Exception Caught: " + e.getMessage());
        }

        
    }

}
