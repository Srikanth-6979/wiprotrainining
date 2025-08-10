package com.wipro.dateandtime;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateAndTimeDemo {

	public static void main(String[] args) {
		
		LocalDate date = LocalDate.of(2023, 11, 1);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        System.out.println(date.format(formatter));

	}

}
