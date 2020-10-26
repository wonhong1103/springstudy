package com.ict.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Ex03_Test {
	Ex03 test1 ;
	Ex04 test2 ;
	@Before
	public void testBefore() {
		test1 = new Ex03();
		test2 = new Ex04();
	}
	@Test
	public void test() {
		assertEquals(100, test1.mul(10, 10));
		test2.div(40, 10);
		assertEquals(4, test2.getRes());
	}

}
