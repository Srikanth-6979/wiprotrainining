package com.wipro.foodms.service;

import java.util.List;

import com.wipro.foodms.entity.Food;

public interface FoodService {
	
	List<Food> getAllFoods();
    Food getFoodById(Long id);
    Food addFood(Food food);
    Food updateFood(Long id, Food food);
    void deleteFood(Long id);

}
