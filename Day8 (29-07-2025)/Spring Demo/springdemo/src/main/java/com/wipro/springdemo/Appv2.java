package com.wipro.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.wipro.springdemo.beans.Mobile;

public class Appv2 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.scan("com.wipro.springdemo.beans");
        ctx.refresh();

        Mobile mob = ctx.getBean(Mobile.class);
        System.out.println(mob);
    }
}
