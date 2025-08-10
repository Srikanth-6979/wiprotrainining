package com.wipro.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparatorDemoTest {

	public static void main(String[] args) {

		EmployeeDemo e1 = new EmployeeDemo("101", "Praveen", 30, 65000.00);
        EmployeeDemo e2 = new EmployeeDemo("102", "Anjali", 28, 82000.00);
        EmployeeDemo e3 = new EmployeeDemo("103", "Ravi", 35, 72000.00);
        EmployeeDemo e4 = new EmployeeDemo("104", "Kiran", 25, 56000.00);

        List<EmployeeDemo> empList = new ArrayList<>();
        empList.add(e1);
        empList.add(e2);
        empList.add(e3);
        empList.add(e4);

//        Collections.sort(empList);
//		System.out.println(empList);
		
		System.out.println( );
		
		Collections.sort(empList,new SortByEmpSalary());
		System.out.println(empList);
		
		System.out.println( );
		
		
		Collections.sort(empList,new SortByEmpName());
		System.out.println(empList);
		
		System.out.println( );
		
		Collections.sort(empList,new SortByEmpAge());
		System.out.println(empList);

	}

}
