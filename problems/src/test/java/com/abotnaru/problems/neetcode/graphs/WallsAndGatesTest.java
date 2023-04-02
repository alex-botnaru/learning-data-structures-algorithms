package com.abotnaru.problems.neetcode.graphs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class WallsAndGatesTest {

	private static final int INF = 2147483647;

	@Test
	void testWalsAndGatesFourByFour() {
		int[][] rooms = new int[][] { { INF, -1, 0, INF }, { INF, INF, INF, -1 }, { INF, -1, INF, -1 },
				{ 0, -1, INF, INF } };
		new WallsAndGates().wallsAndGates(rooms);
		assertEquals(3, rooms[0][0]);
		assertEquals(-1, rooms[0][1]);
		assertEquals(0, rooms[0][2]);
		assertEquals(1, rooms[0][3]);

		assertEquals(2, rooms[1][0]);
		assertEquals(2, rooms[1][1]);
		assertEquals(1, rooms[1][2]);
		assertEquals(-1, rooms[1][3]);

		assertEquals(1, rooms[2][0]);
		assertEquals(-1, rooms[2][1]);
		assertEquals(2, rooms[2][2]);
		assertEquals(-1, rooms[2][3]);

		assertEquals(0, rooms[3][0]);
		assertEquals(-1, rooms[3][1]);
		assertEquals(3, rooms[3][2]);
		assertEquals(4, rooms[3][3]);
	}

	@Test
	void testWalsAndGatesTwoByTwo() {
		int[][] rooms = new int[][] { { 0, -1 }, { INF, INF } };
		new WallsAndGates().wallsAndGates(rooms);
		assertEquals(0, rooms[0][0]);
		assertEquals(-1, rooms[0][1]);

		assertEquals(1, rooms[1][0]);
		assertEquals(2, rooms[1][1]);
	}
}
