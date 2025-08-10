package com.wipro.junitdemo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ParameterizedTestDemo {

	@ParameterizedTest
    @ValueSource(strings = {"hello", "unit", "test"})
    void checkLowerCaseStrings(String str) {
        assertTrue(isAllLowerCase(str));
	}  
    
	public static boolean isAllLowerCase(String str) {
        return str != null && str.equals(str.toLowerCase());
    }

}
