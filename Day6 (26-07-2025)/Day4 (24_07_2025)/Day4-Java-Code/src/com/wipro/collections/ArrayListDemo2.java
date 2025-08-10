package com.wipro.collections;

import java.util.ArrayList;

public class ArrayListDemo2 {

	public static void main(String[] args) {
		
		ArrayList<Integer> num = new ArrayList<>();
		num.add(1);
		num.add(2);
		num.add(3);
		num.add(4);
		num.add(5);
		num.add(4);
		
		System.out.println(num);
		
		num.remove(2);
		
		System.out.println(num);
		
		num.add(30);
		
		System.out.println(num);

	}

}
