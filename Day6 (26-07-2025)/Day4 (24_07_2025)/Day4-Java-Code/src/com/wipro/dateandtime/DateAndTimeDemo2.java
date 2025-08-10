package com.wipro.dateandtime;

import java.time.LocalDate;
import java.time.Period;

public class DateAndTimeDemo2 {

    public static void main(String[] args) {
        LocalDate dob = LocalDate.of(2000, 9, 28);
        System.out.println(getAge(dob));
    }

    public static int getAge(LocalDate dt) {
        LocalDate today = LocalDate.now();
        if ((dt != null) && (dt.isBefore(today) || dt.isEqual(today))) {
            return Period.between(dt, today).getYears();
        } else {
            return 0;
        }
    }
}
