package com.abotnaru.problems.neetcode.advanced.graphs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CheapestFlightsTest {

	@Test
	void testFindCheapestPriceExpect700() {
		assertEquals(700, new CheapestFlights().findCheapestPrice(4,
				new int[][] { { 0, 1, 100 }, { 1, 2, 100 }, { 2, 0, 100 }, { 1, 3, 600 }, { 2, 3, 200 } }, 0, 3, 1));
	}

	@Test
	void testFindCheapestPriceExpect200() {
		assertEquals(200, new CheapestFlights().findCheapestPrice(3,
				new int[][] { { 0, 1, 100 }, { 1, 2, 100 }, { 0, 2, 500 } }, 0, 2, 1));
	}

	@Test
	void testFindCheapestPriceExpect500() {
		assertEquals(500, new CheapestFlights().findCheapestPrice(3,
				new int[][] { { 0, 1, 100 }, { 1, 2, 100 }, { 0, 2, 500 } }, 0, 2, 0));
	}
}
