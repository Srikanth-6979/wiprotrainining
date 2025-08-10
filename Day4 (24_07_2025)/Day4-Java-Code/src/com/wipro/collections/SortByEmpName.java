package com.wipro.collections;

import java.util.Comparator;

public class SortByEmpName implements Comparator<EmployeeDemo> {

	@Override
	public int compare(EmployeeDemo e1, EmployeeDemo e2) {
		
		return e1.getEmpName().compareTo(e2.getEmpName());
	}

}
