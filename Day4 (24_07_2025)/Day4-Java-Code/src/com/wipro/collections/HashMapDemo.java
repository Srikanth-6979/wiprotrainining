package com.wipro.collections;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {

	public static void main(String[] args) {
		Map<String, String> hm = new HashMap<>();
		hm.put("101", "Srikanth");
		hm.put("102", "Sameer");
		hm.put("103", "Nagur");
		hm.put("104", "Sandeep");
		
		System.out.println(hm);
		
//		System.out.println(hm.get("101"));
		
//		hm.put("105", "Farisa");
		
//		System.out.println(hm.containsKey("105"));
		
		System.out.println( );
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		
		
//		for(Map.Entry<String, String> hm1 : hm.entrySet()) {
//			System.out.println(hm1.getKey() + " - " + hm1.getValue());
//		}
		
		
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		
//		for(String key : hm.keySet()) {
//			System.out.println(key);
//		}
//		
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		
		
		for(String value : hm.values()) {
			System.out.println(value);
		}
		

	}

}
