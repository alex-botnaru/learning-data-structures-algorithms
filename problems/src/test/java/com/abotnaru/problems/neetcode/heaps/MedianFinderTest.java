package com.abotnaru.problems.neetcode.heaps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MedianFinderTest {

	@Test
	void testFindMedian() {
		MedianFinder medianFinder = new MedianFinder();

		medianFinder.addNum(1);
		medianFinder.addNum(2);
		assertEquals(1.5, medianFinder.findMedian());
		medianFinder.addNum(3);
		assertEquals(2, medianFinder.findMedian());
	}

}
