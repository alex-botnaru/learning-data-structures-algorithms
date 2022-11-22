package com.abotnaru.problems.neetcode.arrays.hashing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TwoSumTest {

	@Test
	void testTargetNine() {
		int[] actual = new TwoSum().twoSum(new int[] { 2, 7, 11, 15 }, 9);
		assertEquals(0, actual[0]);
		assertEquals(1, actual[1]);
	}

	@Test
	void testTargetSix() {
		int[] actual = new TwoSum().twoSum(new int[] { 3, 2, 4 }, 6);
		assertEquals(1, actual[0]);
		assertEquals(2, actual[1]);
	}

	@Test
	void testTargetAnotherSix() {
		int[] actual = new TwoSum().twoSum(new int[] { 3, 3 }, 6);
		assertEquals(0, actual[0]);
		assertEquals(1, actual[1]);
	}
	
	@Test
	void testTargetAnotherMinsuFive() {
		int[] actual = new TwoSum().twoSum(new int[] { 3, 8, -12, 4, -10, 1, 5, -5, 4}, -5);
		assertEquals(4, actual[0]);
		assertEquals(6, actual[1]);
	}
}
