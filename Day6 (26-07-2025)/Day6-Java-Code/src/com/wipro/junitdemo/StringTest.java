package com.wipro.junitdemo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringTest { 


//	@Test
//    void testUpperCaseString() {
//        String str1 = "HELLO";
//        assertTrue(StringJunit.isAllUpperCase(str1));
//    }
    
	@Test
    void testNullToUpperCaseThrowsException() {
        String str2 = null;

        assertThrows(NullPointerException.class, () -> {
            str2.toUpperCase();
        });
    }
}

