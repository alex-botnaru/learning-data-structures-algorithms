package com.abotnaru.problems.neetcode.heaps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class KthLargestStreamElementTest {

	@Test
	void testKthLargestElementInAStream() {
		KthLargestStreamElement kthLargest = new KthLargestStreamElement(3, new int[] { 4, 5, 8, 2 });
		assertEquals(4, kthLargest.add(3));
		assertEquals(5, kthLargest.add(5));
		assertEquals(5, kthLargest.add(10));
		assertEquals(8, kthLargest.add(9));
		assertEquals(8, kthLargest.add(4));
	}
}
