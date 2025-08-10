package com.wipro.oop;

public class Circle extends Shape {
    private double radius;

    public Circle(String color, double radius) {
        super();
        this.radius = radius;
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return "Circle [radius=" + radius + ", area=" + getArea() + ", " + super.toString() + "]";
    }
}
