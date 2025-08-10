package com.wipro.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.repo.CityRepo;
import com.wipro.service.CityService;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    CityRepo cityRepository;

    @Override
    public List<String> fetchCities() {
        return cityRepository.getAllCities();
    }
}
