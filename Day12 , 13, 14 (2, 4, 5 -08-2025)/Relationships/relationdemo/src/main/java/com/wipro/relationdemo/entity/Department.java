package com.wipro.relationdemo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
	
	@Column(name="dept_name")
	String deptName;
	
//	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
//	@OneToOne(mappedBy="pan" , fetch=FetchType.EAGER)
//	User user;
}
