package com.wipro.relationdemo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.relationdemo.entity.Movie;
import com.wipro.relationdemo.repo.MovieRepo;
import com.wipro.relationdemo.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {
	
	
	@Autowired
	MovieRepo moviRepo;
	
	@Override
	public void save(Movie movie) {
		moviRepo.save(movie);
		
	}

	@Override
	public List<Movie> findAll() {
		
		return moviRepo.findAll();
	}
	

}
