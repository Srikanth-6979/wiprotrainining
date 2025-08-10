package com.wipro.collections;

public class EmployeeDemo implements Comparable<EmployeeDemo> {

    String empid;
    String empName;
    int empAge;
    double empSalary;

    public EmployeeDemo(String empid, String empName, int empAge, double empSalary) {
        this.empid = empid;
        this.empName = empName;
        this.empAge = empAge;
        this.empSalary = empSalary;
    }

    public String getEmpid() {
        return empid;
    }

    public void setEmpid(String empid) {
        this.empid = empid;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public int getEmpAge() {
        return empAge;
    }

    public void setEmpAge(int empAge) {
        this.empAge = empAge;
    }

    public double getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(double empSalary) {
        this.empSalary = empSalary;
    }

    @Override
    public String toString() {
        return "EmployeeDemo [empid=" + empid + ", empName=" + empName + ", empAge=" + empAge + ", empSalary=" + empSalary + "]";
    }

    @Override
    public int compareTo(EmployeeDemo other) {
        
        return Double.compare(other.empSalary, this.empSalary);
    }
}
