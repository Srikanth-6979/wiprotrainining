package com.wipro.threadtest;

import com.wipro.threaddemo.Counter;
import com.wipro.threaddemo.ThreadCounter;

public class ThreadCounterTest {

	public static void main(String[] args) {
		
		Counter counter = new Counter();

        ThreadCounter t1 = new ThreadCounter(counter);
        ThreadCounter t2 = new ThreadCounter(counter);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final count : " + counter.getCount());
		

	}

}
