package com.wipro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiceDiscoveryMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceDiscoveryMsApplication.class, args);
	}

}
