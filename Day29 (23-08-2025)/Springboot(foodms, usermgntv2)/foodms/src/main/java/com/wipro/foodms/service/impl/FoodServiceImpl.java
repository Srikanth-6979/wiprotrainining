package com.wipro.foodms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.foodms.entity.Food;
import com.wipro.foodms.repo.FoodRepo;
import com.wipro.foodms.service.FoodService;

@Service
public class FoodServiceImpl implements FoodService{
	
	@Autowired
	private final FoodRepo foodRepository;

    public FoodServiceImpl(FoodRepo foodRepository) {
        this.foodRepository = foodRepository;
    }

    @Override
    public List<Food> getAllFoods() {
        return foodRepository.findAll();
    }

    @Override
    public Food getFoodById(Long id) {
        return foodRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Food not found with id " + id));
    }

    @Override
    public Food addFood(Food food) {
        return foodRepository.save(food);
    }

    @Override
    public Food updateFood(Long id, Food food) {
        Food existing = getFoodById(id);
        existing.setName(food.getName());
        existing.setDescription(food.getDescription());
        existing.setPrice(food.getPrice());
        existing.setCategory(food.getCategory());
        existing.setFoodImage(food.getFoodImage());
        return foodRepository.save(existing);
    }

    @Override
    public void deleteFood(Long id) {
        foodRepository.deleteById(id);
    }

}
