package com.wipro.dateandtime;

import java.time.LocalDate;

public class LeapYearCheck {

	public static void main(String[] args) {

		LocalDate date = LocalDate.of(2024, 2, 29); 

        if (isLeapYear(date)) {
            System.out.println(date + " is a leap year.");
        } else {
            System.out.println(date + " is not  a leap year.");
        }
    }

    public static boolean isLeapYear(LocalDate date) {
        int year = date.getYear();

        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            return true;
        } else {
            return false;
        }
		        

	}

}
