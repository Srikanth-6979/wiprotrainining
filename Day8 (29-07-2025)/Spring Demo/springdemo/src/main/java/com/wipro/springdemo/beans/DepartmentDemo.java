package com.wipro.springdemo.beans;

public class DepartmentDemo {

    String deptCode;
    String deptName;
    
	public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    
    public String getDeptCode() {
        return deptCode;
    }

    public String getDeptName() {
        return deptName;
    }

    
    @Override
    public String toString() {
        return "Department [deptCode=" + deptCode + ", deptName=" + deptName + "]";
    }
}
