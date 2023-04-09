package com.abotnaru.problems.neetcode.graphs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class RedundantConnectionTest {

	@Test
	void testFindRedundantConnectionExpectTwoThree() {
		int[] edge = new RedundantConnection().findRedundantConnection(new int[][] { { 1, 2 }, { 1, 3 }, { 2, 3 } });
		assertNotNull(edge);
		assertEquals(2, edge.length);
		assertEquals(2, edge[0]);
		assertEquals(3, edge[1]);
	}

	@Test
	void testFindRedundantConnectionExpectOneFour() {
		int[] edge = new RedundantConnection()
				.findRedundantConnection(new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 4 }, { 1, 5 } });
		assertNotNull(edge);
		assertEquals(2, edge.length);
		assertEquals(1, edge[0]);
		assertEquals(4, edge[1]);
	}

}
