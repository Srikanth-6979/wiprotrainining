package com.wipro.firstdemomvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.firstdemomvc.service.CarService;
import com.wipro.firstdemomvc.service.repo.CarRepo;


@Service
public class CarServiceImpl implements CarService {

	@Autowired
    private CarRepo carRepo;

    @Override
    public List<String> getCarList(){
        return carRepo.getAllCars();
    }

}
