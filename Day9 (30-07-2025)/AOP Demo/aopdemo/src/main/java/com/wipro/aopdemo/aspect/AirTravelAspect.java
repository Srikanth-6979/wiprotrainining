package com.wipro.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.wipro.aopdemo.exception.NoSeatAvailableException;


@Aspect
@Component
public class AirTravelAspect {

    @Before("execution(* com.wipro.aopdemo.airtravelprocess.AirTravelProcess.checkIn(..))")
    public void showPhotoId(JoinPoint joinPoint) {
        System.out.println(" -- show your Photo ID -- ");
    }

    @Before("execution(* com.wipro.aopdemo.airtravelprocess.AirTravelProcess.doSecurityCheck(..))")
    public void doSecurityCheck() {
        System.out.println(" -- show your Boarding Pass -- ");
    }

    @Before("execution(* com.wipro.aopdemo.airtravelprocess.AirTravelProcess.doBoarding(..))")
    public void showBoardingPass() {
        System.out.println(" -- show your Boarding Pass -- ");
    }

    @AfterThrowing( pointcut = "execution(* com.wipro.aopdemo.airtravelprocess.AirTravelProcess.checkIn(..))", throwing = "ex" )
    public void handleNoSeatException(NoSeatAvailableException ex) {
        System.out.println("Excpetion : " + ex.getMessage());
    }
}