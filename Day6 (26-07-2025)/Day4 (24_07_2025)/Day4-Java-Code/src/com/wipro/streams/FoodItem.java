package com.wipro.streams;

public class FoodItem {
	
	String foodType;
	String foodName;
	String cusine;
	double price;
	public String getFoodType() {
		return foodType;
	}
	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public String getCusine() {
		return cusine;
	}
	public void setCusine(String cusine) {
		this.cusine = cusine;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public FoodItem(String foodType, String foodName, String cusine, double price) {
		super();
		this.foodType = foodType;
		this.foodName = foodName;
		this.cusine = cusine;
		this.price = price;
	}
	
	
	@Override
	public String toString() {
		return "FoodItem [foodType=" + foodType + ", foodName=" + foodName + ", cusine=" + cusine + ", price=" + price
				+ "]";
	}
	
	

}
