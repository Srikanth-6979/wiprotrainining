package com.wipro.oop;

public class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(String color, double length, double width) {
        super();
        this.length = length;
        this.width = width;
    }

    public int getLength() {
        return (int) length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getArea() {
        return length * width;
    }

    @Override
    public String toString() {
        return "Rectangle [length=" + length + ", width=" + width + ", area=" + getArea() + ", " + super.toString() + "]";
    }
}
