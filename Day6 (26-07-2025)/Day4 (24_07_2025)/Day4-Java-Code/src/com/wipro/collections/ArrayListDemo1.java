package com.wipro.collections;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListDemo1 {

	public static void main(String[] args) {


		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(4);
		
//		for(int i=0;i<list.size();i++) {
//			System.out.println(list.get(i));
//		}

//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		
//		for(int i : list) {
//			System.out.println(i);
//		}
//
		
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		
		Iterator<Integer> it = list.iterator(); 
		
		while(it.hasNext()) {
				System.out.println(it.next());
			}
		
		
	}

}
