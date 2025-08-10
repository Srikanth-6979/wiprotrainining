package com.wipro.relationdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.relationdemo.entity.Movie;
import com.wipro.relationdemo.service.MovieService;

@RestController
@RequestMapping("/api/movies")
public class MovieController {
	
	@Autowired
	MovieService movieService;

    @PostMapping
    public void createMovie(@RequestBody Movie movie) {
    	movieService.save(movie);
    }

    @GetMapping
    public List<Movie> findAll() {
        return movieService.findAll();
    }

}
