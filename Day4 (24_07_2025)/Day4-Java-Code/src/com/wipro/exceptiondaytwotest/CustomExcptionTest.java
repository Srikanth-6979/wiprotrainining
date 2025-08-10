package com.wipro.exceptiondaytwotest;

import com.wipro.exceptiondaytwo.InvalidMonthException;

public class CustomExcptionTest {

	public static void main(String[] args) {
		try {
			checkMonth(0);  
			
        } catch (InvalidMonthException e) {
        	e.printStackTrace();
        }
	}
		
		public static void checkMonth(int month) throws InvalidMonthException {
	        if (month < 1 || month > 12) {
	            throw new InvalidMonthException("Invalid Month");
	        } else {
	            System.out.println("Valid Month: " + month);
	        }
	        
		}

}
