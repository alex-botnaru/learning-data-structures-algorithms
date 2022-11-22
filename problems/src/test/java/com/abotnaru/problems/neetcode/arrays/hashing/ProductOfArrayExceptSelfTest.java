package com.abotnaru.problems.neetcode.arrays.hashing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ProductOfArrayExceptSelfTest {

	/**
	 * 1. Brute force approach, for each index, iterate through all elements again
	 * and compute the product. O(N^2) time complexity
	 * <p>
	 * 2. a) Iterate through array once and compute the product of all elements.<br>
	 * b) Iterate again and divide the product with current element.<br>
	 * c) cover special cases, when there is only one 0, and when there is more than
	 * one zeros<br>
	 * Time complexity O(N)
	 * <p>
	 * 3. Problem statement says O(N) time and no division operation.<br>
	 * a) Create a new array, initialize first element with one.<br>
	 * b) Loop from second element, compute the product of the value in the original
	 * array at current index with previous value from new array.<br>
	 * c) Create a new array, initialize the last value with one.<br>
	 * d) Loop backwards, compute the product of the value in the original array at
	 * current index, with the next value in the new array.<br>
	 * e) Loop again through both arrays. Compute product at each index.<br>
	 */

	@Test
	void testArrayWithTwoElements() {
		int[] actual = new ProductOfArrayExceptSelf().productExceptSelf(new int[] { 8, 5 });
		assertEquals(2, actual.length);
		assertEquals(5, actual[0]);
		assertEquals(8, actual[1]);
	}

	@Test
	void testArrayWithNoZeros() {
		int[] actual = new ProductOfArrayExceptSelf().productExceptSelf(new int[] { 1, 2, 3, 4 });
		assertEquals(4, actual.length);
		assertEquals(24, actual[0]);
		assertEquals(12, actual[1]);
		assertEquals(8, actual[2]);
		assertEquals(6, actual[3]);
	}

	@Test
	void testArrayWithOneZero() {
		int[] actual = new ProductOfArrayExceptSelf().productExceptSelf(new int[] { -1, 1, 0, -3, 3 });
		assertEquals(5, actual.length);
		assertEquals(0, actual[0]);
		assertEquals(0, actual[1]);
		assertEquals(9, actual[2]);
		assertEquals(0, actual[3]);
		assertEquals(0, actual[3]);
	}

	@Test
	void testArrayWithMoreZeros() {
		int[] actual = new ProductOfArrayExceptSelf().productExceptSelf(new int[] { 1, 2, 0, 3, 0 });
		assertEquals(5, actual.length);
		assertEquals(0, actual[0]);
		assertEquals(0, actual[1]);
		assertEquals(0, actual[2]);
		assertEquals(0, actual[3]);
		assertEquals(0, actual[3]);
	}
}
