package com.wipro.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class VectorDemo {

	public static void main(String[] args) {
		
		List<Integer> num = new Vector<>();
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
