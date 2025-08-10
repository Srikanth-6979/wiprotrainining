package com.wipro.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapDemo {

	public static void main(String[] args) {
		
		Map<String, String> cm = new HashMap<>();
        cm.put("USD", "United States Dollar");
        cm.put("INR", "Indian Rupee");
        cm.put("EUR", "Euro");
        
        System.out.println(cm);

        Map<String, String> tm = new TreeMap<>();
        tm.putAll(cm);
        
        System.out.println();
      
		for (Map.Entry<String, String> entry : tm.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }        
		    
	}

}
