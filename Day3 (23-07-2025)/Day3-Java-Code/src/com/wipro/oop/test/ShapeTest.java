package com.wipro.oop.test;

import com.wipro.oop.Circle;
import com.wipro.oop.Rectangle;
import com.wipro.oop.Square;

public class ShapeTest {
    public static void main(String[] args) {
        Circle circle = new Circle("Red", 10.0);
        System.out.println(circle);
        
        
        Rectangle rect = new Rectangle("Blue", 5.0, 3.0);
        System.out.println(rect);
        
        Square square = new Square("Green", 6.0);
        System.out.println(square);
    }
}
