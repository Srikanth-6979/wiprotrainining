package com.wipro.firstdemomvc.service.repo;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;


@Repository
public class CarRepo {
	
	public List<String> getAllCars() {
		
        return Arrays.asList("Audi", "Mercedes", "BMW" , "Fortunner");
    }

}
