package com.abotnaru.problems.neetcode.advanced.graphs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class NetworkDelayTimeTest {

	@Test
	void testNetworkDelayTimeExpectTwo() {
		assertEquals(2,
				new NetworkDelayTime().networkDelayTime(new int[][] { { 2, 1, 1 }, { 2, 3, 1 }, { 3, 4, 1 } }, 4, 2));
	}

	@Test
	void testNetworkDelayTimeExpectOne() {
		assertEquals(1, new NetworkDelayTime().networkDelayTime(new int[][] { { 1, 2, 1 } }, 2, 1));
	}

	@Test
	void testNetworkDelayTimeExpectMinusOne() {
		assertEquals(-1, new NetworkDelayTime().networkDelayTime(new int[][] { { 1, 2, 1 } }, 2, 2));
	}
}
