package com.abotnaru.problems.neetcode.heaps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class KthLargestArrayElementTest {

	@Test
	void testFindKthLargestAndExpectFive() {
		assertEquals(5, new KthLargestArrayElement().findKthLargest(new int[] { 3, 2, 1, 5, 6, 4 }, 2));
	}

	@Test
	void testFindKthLargestAndExpectFour() {
		assertEquals(4, new KthLargestArrayElement().findKthLargest(new int[] { 3, 2, 3, 1, 2, 4, 5, 5, 6 }, 4));
	}
}
