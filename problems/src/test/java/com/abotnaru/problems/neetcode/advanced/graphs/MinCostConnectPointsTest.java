package com.abotnaru.problems.neetcode.advanced.graphs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MinCostConnectPointsTest {

	@Test
	void testMinCostConnectPointsExpectTwenty() {
		assertEquals(20, new MinCostConnectPoints()
				.minCostConnectPoints(new int[][] { { 0, 0 }, { 2, 2 }, { 3, 10 }, { 5, 2 }, { 7, 0 } }));
	}

	@Test
	void testMinCostConnectPointsExpectEighteen() {
		assertEquals(18,
				new MinCostConnectPoints().minCostConnectPoints(new int[][] { { 3, 12 }, { -2, 5 }, { -4, 1 } }));
	}
}
