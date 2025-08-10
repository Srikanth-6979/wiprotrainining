package com.wipro.dateandtime;

import java.time.LocalDate;

public class DateAndTimeDemo3 {
	
	    public static void main(String[] args) {
	        LocalDate d1 = LocalDate.of(2024, 12, 25);
	        LocalDate d2 = LocalDate.of(2025, 1, 6);

	        getDateDiff(d1, d2);
	    }

	    public static void getDateDiff(LocalDate d1, LocalDate d2) {
	        if (d1.isAfter(d2)) {
	            LocalDate temp = d1;
	            d1 = d2;
	            d2 = temp;
	        }

	        int years = d2.getYear() - d1.getYear();
	        int months = d2.getMonthValue() - d1.getMonthValue();
	        int days = d2.getDayOfMonth() - d1.getDayOfMonth();

	        if (days < 0) {
	            days += d1.lengthOfMonth();
	            months--;
	        }
	        if (months < 0) {
	            months += 12;
	            years--;
	        }

	        System.out.println("Difference: " + years + " years, " + months + " months, " + days + " days");
	    }
	}
