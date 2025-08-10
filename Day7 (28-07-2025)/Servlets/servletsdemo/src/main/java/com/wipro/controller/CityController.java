package com.wipro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.wipro.service.CityService;

@Controller
public class CityController {
    
    @Autowired
    CityService cityService;

    @GetMapping("/cities")
    public String showCityList(Model model) {
        model.addAttribute("cities", cityService.fetchCities());
        return "cities";  
    }
}
