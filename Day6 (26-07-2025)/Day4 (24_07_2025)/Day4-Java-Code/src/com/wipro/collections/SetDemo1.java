package com.wipro.collections;

import java.util.HashSet;
import java.util.Set;

public class SetDemo1 {

	public static void main(String[] args) {
		
		Set<Integer> setA = new HashSet<>();
        setA.add(10);
        setA.add(20);
        setA.add(30);
        setA.add(40);
        
        System.out.println(setA);

        Set<Integer> setB = new HashSet<>();
        setB.add(30);
        setB.add(40);
        setB.add(50);
        setB.add(60);
        
        System.out.println(setB);

        setA.removeAll(setB); 

        System.out.println(setA);

	}

}
