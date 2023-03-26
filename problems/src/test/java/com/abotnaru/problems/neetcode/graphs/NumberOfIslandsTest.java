package com.abotnaru.problems.neetcode.graphs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class NumberOfIslandsTest {

	@Test
	void testNumIslandsExpectOne() {
		assertEquals(1, new NumberOfIslands().numIslands(new char[][] { { '1', '1', '1', '1', '0' },
				{ '1', '1', '0', '1', '0' }, { '1', '1', '0', '0', '0' }, { '0', '0', '0', '0', '0' } }));
	}

	@Test
	void testNumIslandsExpectThree() {
		assertEquals(3, new NumberOfIslands().numIslands(new char[][] { { '1', '1', '0', '0', '0' },
				{ '1', '1', '0', '0', '0' }, { '0', '0', '1', '0', '0' }, { '0', '0', '0', '1', '1' } }));
	}
}
