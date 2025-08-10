package com.wipro.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FoodItemTest {

	public static void main(String[] args) {
		
		FoodItem f1 = new FoodItem("Biryani", "non-veg", "Continental", 400);
		FoodItem f2 = new FoodItem("FriedRice", "non-veg", "Chinese", 200);
		FoodItem f3 = new FoodItem("Noodles", "veg", "Chinese", 150);
		FoodItem f4 = new FoodItem("Rice", "veg", "Thali", 500);
		FoodItem f5 = new FoodItem("Chicken Noodles", "non-veg", "Chinese", 350);
		
		List<FoodItem> fi = new ArrayList<>();
		fi.add(f1);
		fi.add(f2);
		fi.add(f3);
		fi.add(f4);
		fi.add(f5);
		
//		 chineseFoods = fi.stream()
//	          .filter(food -> food.getCusine().equalsIgnoreCase("Chinese"))
//	          .collect(Collectors.toList());
//
//
//		for (FoodItem food2 : chineseFoods) {
//			System.out.println(food2);
//		}
		
		FoodItem item = fi.stream()
			    .filter(i -> i.getCusine().equalsIgnoreCase("Chinese"))
			    .reduce((x, y) -> x.getPrice() > y.getPrice() ? x : y)
			    .orElse(null);
			

			if (item != null) {
			    System.out.println(item);
			}
	}

}
