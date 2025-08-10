package com.wipro.oop.test;

import com.wipro.oop.Converter;

public class ConverterTest {

	public static void main(String[] args) {
		
		Converter con = new Converter();
		System.out.println(con.Convert(2));
		System.out.println(con.Convert(5, 7));
		System.out.println(con.Convert(6.0));
		
	}

}
