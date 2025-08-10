package com.wipro.exception;

public class NullPointerDemo {

	public static void main(String[] args) {
		
				String fName = null;
				//fName.toUpperCase();
				
				try {
		            String upper = fName.toUpperCase();
		            System.out.println("Uppercase: " + upper);
		        } catch (NullPointerException e) {
		            System.out.println("Caught " + e + " : fName is null");
		        }
	}

}
