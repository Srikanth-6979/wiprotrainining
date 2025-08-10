package com.wipro.collections;

public class ComparatorDemo {

	    String empid;
	    String empName;
	    int empAge;
	    double empSalary;

	    public ComparatorDemo (String empid, String empName, int empAge, double empSalary) {
	    	super();
	        this.empid = empid;
	        this.empName = empName;
	        this.empAge = empAge;
	        this.empSalary = empSalary;
	    }

	    public String getEmpid() {
	        return empid;
	    }

	    public String getEmpName() {
	        return empName;
	    }

	    public int getEmpAge() {
	        return empAge;
	    }

	    public double getEmpSalary() {
	        return empSalary;
	    }

	    @Override
	    public String toString() {
	        return "EmployeeDemo [empid=" + empid + ", empName=" + empName + ", empAge=" + empAge + ", empSalary=" + empSalary + "]";
	    }
	

}
