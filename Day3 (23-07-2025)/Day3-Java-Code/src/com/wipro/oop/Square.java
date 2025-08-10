package com.wipro.oop;

public class Square extends Shape {
    private double side;

    public Square(String color, double side) {
        super();
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double getArea() {
        return side * side;
    }

    @Override
    public String toString() {
        return "Square [side=" + side + ", area=" + getArea() + ", " + super.toString() + "]";
    }
}
