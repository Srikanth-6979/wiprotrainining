package com.wipro.collections;

import java.util.Comparator;

public class SortByEmpSalary implements Comparator<EmployeeDemo>  {

	@Override
	public int compare(EmployeeDemo e1, EmployeeDemo e2) {
		
		return Double.compare(e2.getEmpSalary(), e1.getEmpSalary());
	}

}
