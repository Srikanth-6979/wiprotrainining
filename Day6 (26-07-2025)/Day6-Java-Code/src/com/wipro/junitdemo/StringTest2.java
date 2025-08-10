package com.wipro.junitdemo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StringTest {

    @BeforeAll
    static void startup() {
        System.out.println("== Test started ==");
    }

    @BeforeEach
    void setup() {
        System.out.println("-- Setup before test --");
    }

    @Test
    void testUpperCaseString() {
        String str1 = "HELLO";
        assertTrue(StringJunit.isAllUpperCase(str1));
    }
    
    @Test
    void testNullToUpperCaseThrowsException() {
        String str2 = null;

        assertThrows(NullPointerException.class, () -> {
            str2.toUpperCase(); 
        });
    }
    
    @Test
    void testLowerCaseString() {
        String input = "hello";
        assertFalse(StringJunit.isAllUpperCase(input));
    }

    @Test
    void testMixedCaseString() {
        String input = "HelloWorld";
        assertFalse(StringJunit.isAllUpperCase(input));
    }

    @Test
    void testEmptyString() {
        String input = "";
        assertTrue(StringJunit.isAllUpperCase(input));
    }

    @Test
    void testNullString() {
        String input = null;
        assertFalse(StringJunit.isAllUpperCase(input));
    }

    @AfterEach
    void teardown() {
        System.out.println("-- Teardown after test --");
    }

    @AfterAll
    static void destroy() {
        System.out.println("== All tests completed ==");
    }
}

