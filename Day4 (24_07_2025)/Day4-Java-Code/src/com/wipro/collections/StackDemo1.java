package com.wipro.collections;

import java.util.List;
import java.util.Stack;

public class StackDemo1 {

	public static void main(String[] args) {
		
		Stack<String> sd = new Stack<>();
		sd.push("Physics");
		sd.push("Maths");
		sd.push("English");
		sd.push("Hindi");
		
		System.out.println(sd);
		
		sd.pop();
		
		System.out.println(sd.peek());
		
		System.out.println(sd);
		
		

	}

}
