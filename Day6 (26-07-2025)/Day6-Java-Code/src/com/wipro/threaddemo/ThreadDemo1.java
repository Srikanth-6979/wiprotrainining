package com.wipro.threaddemo;

public class ThreadDemo1 extends Thread {
	
	public void run() {
		
		System.out.print("Number: " );
        for (int i = 1; i <= 10; i++) {
            System.out.print(i + " ");
            
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
        }
	}   
}
