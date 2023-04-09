package com.abotnaru.problems.neetcode.graphs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ConnectedComponentsTest {
	
	@Test
	void testNumberOfConnectedComponents() {
		assertEquals(2, new ConnectedComponents().countComponents(5, new int[][] {{0, 1}, {1, 2}, {3, 4}}));
	}

}
