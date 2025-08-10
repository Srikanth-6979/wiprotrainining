package com.wipro.oop.test;

import com.wipro.oop.Animal;
import com.wipro.oop.Bird;
import com.wipro.oop.Dog;
import com.wipro.oop.Human;

public class AnimalTest {

	public static void main(String[] args) {
		
		Animal human = new Human("John", 30);
        Animal bird = new Bird("Sparrow", 2);
        Animal dog = new Dog("Jimmy", 15);
        
        human.makeSound();
        System.out.println(human);
        
        bird.makeSound();
        System.out.println(bird);
        
        dog.makeSound();
        System.out.println(dog);
		

	}

}
