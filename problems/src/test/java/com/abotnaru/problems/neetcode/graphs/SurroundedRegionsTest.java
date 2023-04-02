package com.abotnaru.problems.neetcode.graphs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SurroundedRegionsTest {

	@Test
	void testSurroundedRegions() {
		char[][] board = new char[][] { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' },
				{ 'X', 'O', 'X', 'X' } };
		new SurroundedRegions().solve(board);

		assertEquals('X', board[1][1]);
		assertEquals('X', board[1][2]);
		assertEquals('X', board[2][2]);
		assertEquals('O', board[3][1]);
	}
}
