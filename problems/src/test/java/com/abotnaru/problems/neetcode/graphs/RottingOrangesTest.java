package com.abotnaru.problems.neetcode.graphs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class RottingOrangesTest {

	@Test
	void testOrgangesRottingExpectFour() {
		assertEquals(4, new RottingOranges().orangesRotting(new int[][] { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } }));
	}

	@Test
	void testOrgangesRottingExpectMinusOne() {
		assertEquals(-1, new RottingOranges().orangesRotting(new int[][] { { 2, 1, 1, }, { 0, 1, 1 }, { 1, 0, 1 } }));
	}

	@Test
	void testOrgangesRottingExpectZero() {
		assertEquals(0, new RottingOranges().orangesRotting(new int[][] { { 0, 2 } }));
	}
}
