package com.wipro.collections;

import java.util.LinkedList;
import java.util.List;

public class LinkedListDemo {

	public static void main(String[] args) {
		
		List<Integer> num = new LinkedList<>();
		num.add(6);
		num.add(2);
		num.add(5);
		num.add(3);
		num.add(4);
		num.add(1);
				
		System.out.println(num);
				
		num.remove(2);
				
		System.out.println(num);
				
		num.add(30);
				
		System.out.println(num);

	}

}
