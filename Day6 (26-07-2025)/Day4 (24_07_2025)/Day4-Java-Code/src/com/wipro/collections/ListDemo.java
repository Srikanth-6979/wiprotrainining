package com.wipro.collections;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class ListDemo {

	public static void main(String[] args) {
		
		List<Integer> num = new ArrayList<>();
			num.add(10);
			num.add(20);
			num.add(30);
			num.add(20);  
			num.add(10); 
			num.add(60);

			System.out.println(num);

			Set<Integer> set = new LinkedHashSet<>(num);
			set.addAll(num);

       
			System.out.println(set);
		    }

}
