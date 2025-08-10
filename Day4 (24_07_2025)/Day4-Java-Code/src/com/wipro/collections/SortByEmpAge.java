package com.wipro.collections;

import java.util.Comparator;

public class SortByEmpAge implements Comparator<EmployeeDemo> {

	@Override
	public int compare(EmployeeDemo e1, EmployeeDemo e2) {
		
		return Integer.compare(e1.getEmpAge(), e2.getEmpAge());
	}


}
