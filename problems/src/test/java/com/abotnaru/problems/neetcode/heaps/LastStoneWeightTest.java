package com.abotnaru.problems.neetcode.heaps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class LastStoneWeightTest {

	@Test
	void testlastStoneWeightSixValuesExpectOne() {
		assertEquals(1, new LastStoneWeight().lastStoneWeight(new int[] { 2, 7, 4, 1, 8, 1 }));
	}

	@Test
	void testlastStoneWeightOneValueExpectOne() {
		assertEquals(1, new LastStoneWeight().lastStoneWeight(new int[] { 1 }));
	}

}
