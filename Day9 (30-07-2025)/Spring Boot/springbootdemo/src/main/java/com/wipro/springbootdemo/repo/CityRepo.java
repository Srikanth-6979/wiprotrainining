package com.wipro.springbootdemo.repo;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class CityRepo {
	
	public List<String> getCities() {
        return Arrays.asList("Hyderabad", "Mumbai", "Delhi", "Chennai", "Bangalore");
    }

}
