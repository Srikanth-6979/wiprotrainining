package com.wipro.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDemo1 {

	public static void main(String[] args) {
		
		List<String> names = Arrays.asList("Jayanta", "Jnanendra", "Jagan","John", "Ajay");

        
        List<String> result = names.stream()
                //.filter(name -> name.toLowerCase().contains("ja"))
        		.filter(name -> name.contains("ja") || name.contains("Ja") || name.contains("JA") || name.contains("jA"))
                .collect(Collectors.toList());

        System.out.println("Names of 'ja': " + result);

	}

}
