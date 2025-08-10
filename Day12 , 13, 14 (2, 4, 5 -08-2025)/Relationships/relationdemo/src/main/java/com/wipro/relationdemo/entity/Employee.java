package com.wipro.relationdemo.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "employees")
public class Employee {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    int id;
	    
	    @Column(name = "emp_id")
	    String empId;
	    
	    @Column(name = "emp_name")
	    String empName;

	    @OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "dept_id", referencedColumnName = "id")
	    Department dept;

	    
	    
}

