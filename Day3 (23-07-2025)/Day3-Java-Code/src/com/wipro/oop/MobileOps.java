package com.wipro.oop;

public interface MobileOps {
	
	// functions 
	
	void makeCall(String phoneNumber);
	void takePhoto();
	void turnOnWifi();
	
	default void sleep() {
		System.out.println("default");
	}
}
