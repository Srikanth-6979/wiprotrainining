package com.wipro.exceptiondaytwo;

public class InvalidMonthException extends Exception {
	
	String Message;

	public InvalidMonthException(String message) {
		super();
		Message = message;
	}
	
	
}
