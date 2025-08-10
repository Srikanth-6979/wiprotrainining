package com.wipro.springdemo.beans;

public class College {

    String collegeName;
    DepartmentDemo department;

    public College(String collegeName, DepartmentDemo department) {
		super();
		this.collegeName = collegeName;
		this.department = department;
	}

//	public String getCollegeName() {
//        return collegeName;
//    }
//
//    public void setCollegeName(String collegeName) {
//        this.collegeName = collegeName;
//    }
//
//    public DepartmentDemo getDepartment() { 
//        return department;
//    }
//
//    public void setDepartment(DepartmentDemo department) {  
//        this.department = department;
//    }

    @Override
    public String toString() {
        return "College [collegeName=" + collegeName + ", department=" + department + "]";
    }
}
