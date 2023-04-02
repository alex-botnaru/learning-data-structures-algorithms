package com.abotnaru.problems.neetcode.graphs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;

class PacificAtlanticWaterFlowTest {

	@Test
	void testPacificAtlanticExpectSevenCells() {
		int[][] map = new int[][] { { 1, 2, 2, 3, 5 }, { 3, 2, 3, 4, 4 }, { 2, 4, 5, 3, 1 }, { 6, 7, 1, 4, 5 },
				{ 5, 1, 1, 2, 4 } };
		List<List<Integer>> result = new PacificAtlanticWaterFlow().pacificAtlantic(map);
		assertNotNull(result);
		assertEquals(7, result.size());
	}

	@Test
	void testPacificAtlanticExpectOneCell() {
		int[][] map = new int[][] { { 1 } };
		List<List<Integer>> result = new PacificAtlanticWaterFlow().pacificAtlantic(map);
		assertNotNull(result);
		assertEquals(1, result.size());
		assertEquals(0, result.get(0).get(0));
		assertEquals(0, result.get(0).get(1));
	}

}
