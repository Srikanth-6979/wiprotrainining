package com.wipro.oop;

public class Human extends Animal{
	
	public Human(String name, int age) {
        super(name, age);
    }
 

	public void makeSound() {
		System.out.println(name + " says: Hello!");
		
	}

}
