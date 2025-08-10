package com.wipro.junitdemo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.platform.suite.api.Suite;

import org.junit.jupiter.api.Test;
import org.junit.platform.suite.api.SelectPackages;

class JunitSuiteDemo {
	
	@Suite
	@SelectPackages("com.wipro.junitdemo")
	public class TestSuiteAll {
		
		
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
