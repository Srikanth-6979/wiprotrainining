package com.wipro.threaddemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorsDemo2 {

		public static void sleepOneSecond() {
	        try {
	            Thread.sleep(1000);
	        } catch (InterruptedException e) {
	            Thread.currentThread().interrupt();
	        }
	    }

	    public static void main(String[] args) throws Exception {

	        ExecutorService ex = Executors.newFixedThreadPool(5);

	        
	        Future<?> f1 = ex.submit(() -> {
	            System.out.print("Task 1: ");
	            for (int i = 1; i <= 10; i++) {
	                System.out.print(i + " ");
	                sleepOneSecond();
	            }
	            System.out.println();
	        });
	        f1.get(); 

	        
	        Future<?> f2 = ex.submit(() -> {
	            System.out.print("Task 2: ");
	            for (int i = 1; i <= 10; i++) {
	                System.out.print(i + " ");
	                sleepOneSecond();
	            }
	            System.out.println();
	        });
	        f2.get(); 

	        
	        Future<?> f3 = ex.submit(() -> {
	            System.out.print("Task 3: ");
	            for (int i = 1; i <= 10; i++) {
	                System.out.print(i + " ");
	                sleepOneSecond();
	            }
	            System.out.println();
	        });
	        f3.get();
	        

	        Future<?> f4 = ex.submit(() -> {
	            System.out.print("Task 4: ");
	            for (int i = 1; i <= 10; i++) {
	                System.out.print(i + " ");
	                sleepOneSecond();
	            }
	            System.out.println();
	        });
	        f4.get();

	        
	        Future<> f5 = ex.submit(() -> {
	            System.out.print("Task 5: ");
	            for (int i = 1; i <= 10; i++) {
	                System.out.print(i + " ");
	                sleepOneSecond();
	            }
	            System.out.println();
	        });
	        f5.get();

	        ex.shutdown();

	}

}
