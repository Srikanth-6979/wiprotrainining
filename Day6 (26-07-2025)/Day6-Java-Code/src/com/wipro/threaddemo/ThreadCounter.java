package com.wipro.threaddemo;

public class ThreadCounter extends Thread {
	
	
	Counter counter;  //shared Object get from main class counter object...

    public ThreadCounter(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            counter.increment(); 
//            try {
//                Thread.sleep(1000);  
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
        
	}
	

}
