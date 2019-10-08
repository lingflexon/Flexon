package com.flexontechnology.devops.arraytest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ArrayTester {
	static ArrayTest a;
	@BeforeClass
	public static void init() {
		a = new ArrayTest();
	}

	
	@Test
	public void test1() {
		int [] array = {91, 21, 71, 8, 2};
		a.sortDescend(array);
		int [] result = {91, 71, 21, 8, 2};
		assertArrayEquals(result, array);
		
	}
	@Test
	public void test2() {
		int [] array = {12,3,4,8,9,12};
//		ArrayTest a = new ArrayTest();
		a.sortDescend(array);
		int [] result = {12,12,9,8,4,3};
		assertArrayEquals(result, array);
		
	}
	@Test
	public void test3() {
		int [] array = null;
//		ArrayTest a = new ArrayTest();
		a.sortDescend(array);
		int [] result = null;
		assertArrayEquals(result, array);
		
	}
	@Test
	public void testgetInteger() {
		int [] array = {91, 71, 21, 8, 2};
		int value = 11;
//		ArrayTest a = new ArrayTest();
		assertEquals(-1, a.getInteger(array, value));
	}
	@Test
	public void testfindMin() {
		int [] array = {91, 71, 21, 8, 2};
		int value = 2;
//		 ArrayTest a = new ArrayTest();
		assertEquals(value, a.findMin(array));
		
	}
	@Test
	public void testfindMax() {
		int [] array = {91, 71, 21, 8, 2};
		int value = 91;
//		ArrayTest a = new ArrayTest();
		assertEquals(value, a.findMax(array));
	}
	@Test
	public void testreverseArray() {
		int [] array = {91, 71, 21, 8, 2};
		int [] res = {2,8,21,71,91};
//		ArrayTest a = new ArrayTest();
		a.reverseArray(array);
		assertArrayEquals(res, array);
	}
	@Test
	public void testsortInteger() {
		int [] array = {91, 71, 21, 8, 2};
		int [] res = {91,71,21,8,2};
//		ArrayTest a = new ArrayTest();
		assertArrayEquals(res, a.sortIntegers(array));
	}
}
