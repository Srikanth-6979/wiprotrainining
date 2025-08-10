package com.wipro.threaddemo;

public class ThreadDemo2 extends Thread {
	
	public void run() {
		
		System.out.println();
		System.out.print("Alphabet: ");
		for (char ch = 'A'; ch <= 'J'; ch++) {
	        System.out.print(ch + " ");
	        try {
	            Thread.sleep(100);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
		}
	    
	}

}
