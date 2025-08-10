package com.wipro.oop;

public abstract class Animal {
	
	String name;
    int age;
    
    public Animal(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
   


	public void Animal1(String name2, int age2) {
		
	}


	public void Animal2(String name3, int age3) {
		
	}


	public abstract void makeSound();
	

	@Override
	public String toString() {
		return "Animal [name=" + name + ", age=" + age + "]";
	}

}
