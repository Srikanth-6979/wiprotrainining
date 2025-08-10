package com.wipro.collections;

public class GenDemoTest {

	public static void main(String[] args) {
		
		     
		        GenDemo<String> b1 = new GenDemo();
		        b1.setItem("Hello, Generics!");
		        System.out.println(b1.getItem());

		
		        GenDemo<Integer> b2 = new GenDemo<>();
		        b2.setItem(42);
		        System.out.println(b2.getItem());

	}

}
