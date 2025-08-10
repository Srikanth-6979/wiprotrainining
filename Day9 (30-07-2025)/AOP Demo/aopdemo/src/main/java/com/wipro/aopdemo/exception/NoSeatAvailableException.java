package com.wipro.aopdemo.exception;

public class NoSeatAvailableException extends Exception {

    public NoSeatAvailableException() {
        super("No seats are available");
    }

    public NoSeatAvailableException(String message) {
        super(message);
    }
}
