package com.abotnaru.problems.neetcode.graphs;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class GraphValidTreeTest {

	@Test
	void testGraphValidTreeExpectTrue() {
		assertTrue(new GraphValidTree().validTree(5, new int[][] { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 4 } }));
	}

	@Test
	void testGraphValidTreeExpectFalse() {
		assertFalse(
				new GraphValidTree().validTree(5, new int[][] { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 1, 3 }, { 1, 4 } }));
	}

}
