package com.wipro.springbootdemo.repo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.wipro.springbootdemo.service.CityService;

import org.springframework.ui.Model;

@Controller
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping("/cities")
    public String showCities(Model model) {
        model.addAttribute("cities", cityService.fetchCities());
        return "citylist";
    }
}

