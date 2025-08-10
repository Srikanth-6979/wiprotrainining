package com.wipro.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.wipro.springdemo.beans.DepartmentDemo;

public class App {
    public static void main(String[] args) {
    	ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
    	DepartmentDemo dd = ctx.getBean(DepartmentDemo.class); 

    	dd.setDeptName("Finance");
    	dd.setDeptCode("Fin");

    	System.out.println(dd);

    }
}
