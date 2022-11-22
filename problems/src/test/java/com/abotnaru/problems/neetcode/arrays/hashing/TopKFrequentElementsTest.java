package com.abotnaru.problems.neetcode.arrays.hashing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class TopKFrequentElementsTest {

	@Test
	void testOneElementKIsOne() {
		int[] actual = new TopKFrequentElements().topKFrequent(new int[] { 1 }, 1);
		assertEquals(1, actual.length);
		assertEquals(1, actual[0]);
	}

	@Test
	void testMultipleElementsKIsTwo() {
		int[] actual = new TopKFrequentElements().topKFrequent(new int[] { 1, 1, 1, 2, 2, 3 }, 2);
		assertEquals(2, actual.length);
		assertEquals(1, actual[0]);
		assertEquals(2, actual[1]);
	}

	@Test
	void testMultipleElementsKIsThree() {
		int[] actual = new TopKFrequentElements().topKFrequent(new int[] { 1, 1, 1, 2, 2, 3 }, 3);
		assertEquals(3, actual.length);
		assertEquals(1, actual[0]);
		assertEquals(2, actual[1]);
		assertEquals(3, actual[2]);
	}

	@Test
	void testMultipleElementsKIsFour() {
		int[] actual = new TopKFrequentElements()
				.topKFrequent(new int[] { 2, 34, 8, 1, 17, 8, 1, 34, 1, 2, 2, 3, 34, 7, 2, 8, 34, 3, 2, 19 }, 4);
		assertEquals(4, actual.length);
		Arrays.sort(actual);
		assertTrue(Arrays.binarySearch(actual, 2) >= 0);
		assertTrue(Arrays.binarySearch(actual, 34) >= 0);
		assertTrue(Arrays.binarySearch(actual, 8) >= 0);
		assertTrue(Arrays.binarySearch(actual, 1) >= 0);
	}
}
