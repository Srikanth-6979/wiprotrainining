package com.wipro.aopdemo.aspectconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan("com.wipro.aopdemo")
@EnableAspectJAutoProxy
public class AppConfig {

}
