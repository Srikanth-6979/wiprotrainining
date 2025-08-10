package com.wipro.threadtest;

import com.wipro.threaddemo.ThreadDemo1;
import com.wipro.threaddemo.ThreadDemo2;

public class ThreadDemo1Test {

	public static void main(String[] args) {


		ThreadDemo1 t1 = new ThreadDemo1();
		ThreadDemo2 t2 = new ThreadDemo2();
		
		t1.start();
		
		try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		
		t2.start();
		
	}

}
