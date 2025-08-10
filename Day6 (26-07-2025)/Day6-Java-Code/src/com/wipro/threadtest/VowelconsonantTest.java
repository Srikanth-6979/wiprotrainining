package com.wipro.threadtest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.wipro.threaddemo.ConsonantThread;
import com.wipro.threaddemo.VowelThread;

public class VowelconsonantTest {

	public static void main(String[] args) {
		
		List<String> list= new ArrayList<>();
		list = Arrays.asList("Srikanth","Andhra", "Union", "Vamsi", "English", "Chaitu", "Onion");
		
		Thread vt = new Thread(new VowelThread(list));
        Thread ct = new Thread(new ConsonantThread(list));
        
//        VowelThread vt = new VowelThread(list);
//		ConsonantThread ct = new ConsonantThread(list);

        vt.start();
        ct.start();

        try {
            vt.join();
            ct.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final List: " + list);
    }

}
