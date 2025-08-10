package com.wipro.streams;

import java.util.Optional;

public class OptionalDemo {

	public static void main(String[] args) {
//
//		Optional<String> str = Optional.of("Srikanth");
//		System.out.println(str);
		

//		Optional<String> str = Optional.ofNullable(null);
//		System.out.println(str);
		
		Optional<Integer> opt = Optional.of(100);

        
        if(opt.isPresent()) {
        	System.out.println(opt);
        }

        Optional<Integer> emptyOpt = Optional.empty();

        Integer value = emptyOpt.orElse(50);
        System.out.println("Default 	: " + value);

	}

}
