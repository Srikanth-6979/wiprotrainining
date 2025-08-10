package com.wipro.threaddemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsDemo1 {

    public static void main(String[] args) {

    	ExecutorService ex = Executors.newSingleThreadExecutor();

        ex.submit(() -> {
            System.out.print("Task 1: ");
            for (int i = 1; i <= 10; i++) {
                System.out.print(i + " ");
           
            }
            System.out.println();
        });
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        System.out.println("Task 1 is Completed");

       
        ex.submit(() -> {
            System.out.print("Task 2: ");
            for (int i = 1; i <= 10; i++) {
                System.out.print(i + " ");
            }
            System.out.println();
        });

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Task 2 is Completed");
        
        ex.submit(() -> {
            System.out.print("Task 3: ");
            for (int i = 1; i <= 10; i++) {
                System.out.print(i + " ");
            }
            System.out.println();
        });

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        	e.printStackTrace();
        }
        
        System.out.println("Task 3 is Completed");
        
        ex.submit(() -> {
            System.out.print("Task 4: ");
            for (int i = 1; i <= 10; i++) {
                System.out.print(i + " ");
            }
            System.out.println();
        });

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        	e.printStackTrace();
        }
        
        System.out.println("Task 4 is Completed");
        
        ex.submit(() -> {
            System.out.print("Task 5: ");
            for (int i = 1; i <= 10; i++) {
                System.out.print(i + " ");
            }
            System.out.println();
        });
        
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        	e.printStackTrace();
        }
        
        System.out.println("Task 5 is Completed");

        ex.shutdown();
        
        
    }
}