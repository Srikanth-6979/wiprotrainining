package com.wipro.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.wipro.aopdemo.airtravelprocess.AirTravelProcess;
import com.wipro.aopdemo.aspectconfig.AppConfig;
import com.wipro.aopdemo.exception.NoSeatAvailableException;

public class App 
{
    public static void main( String[] args )
    {
    	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
    	//ctx.scan("com.wipro.aopdemo.*");
        AirTravelProcess process = ctx.getBean(AirTravelProcess.class);

        try {
            process.checkIn(true); 
            process.collectBoardingPass();
            process.doSecurityCheck();
            process.doBoarding();
        } catch (NoSeatAvailableException e) {
            //e.printStackTrace();
        }

    }
}
