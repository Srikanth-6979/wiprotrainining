package com.wipro.collections;

import java.util.concurrent.CopyOnWriteArrayList;

public class RemoveHighSalaryWithoutIterator {

    public static void main(String[] args) {

        CopyOnWriteArrayList<EmployeeDemo> empList = new CopyOnWriteArrayList<>();

        EmployeeDemo ed1 = new EmployeeDemo("101", "Praveen", 30, 65000.00);
        EmployeeDemo ed2 = new EmployeeDemo("102", "Anjali", 28, 82000.00);
        EmployeeDemo ed3 = new EmployeeDemo("103", "Ravi", 35, 90000.00);
        EmployeeDemo ed4 = new EmployeeDemo("104", "Kiran", 25, 56000.00);
        EmployeeDemo ed5 = new EmployeeDemo("105", "Manoj", 40, 120000.00);

        empList.add(ed1);
        empList.add(ed2);
        empList.add(ed3);
        empList.add(ed4);
        empList.add(ed5);

        //System.out.println(empList);
        
        System.out.println( );
        for (EmployeeDemo emp : empList) {
            System.out.println(emp);
        }

        
        for (int i = 0; i < empList.size(); i++) {
            if (empList.get(i).getEmpSalary() > 80000) {
                empList.remove(i);
                i--; 
            }
        }

        System.out.println( );
        
        for (EmployeeDemo emp : empList) {
            System.out.println(emp);
        }
    }
}
