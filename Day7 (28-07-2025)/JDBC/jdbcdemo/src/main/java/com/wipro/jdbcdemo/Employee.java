package com.wipro.jdbcdemo;

public class Employee {
	public String name;
    public int age;
    public double salary;
    
	public Employee(String name, int age, double salary) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
    
	public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }
    
    

}
