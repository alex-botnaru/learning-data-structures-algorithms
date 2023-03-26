package com.abotnaru.problems.neetcode.backtracking;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;

class NQueensTest {

	@Test
	void testNQueensFour() {
		List<List<String>> result = new NQueens().solveNQueens(4);
		assertNotNull(result);
		assertEquals(2, result.size());
	}

	@Test
	void testNQueensOne() {
		List<List<String>> result = new NQueens().solveNQueens(1);
		assertNotNull(result);
		assertEquals(1, result.size());
	}

	@Test
	void testNQueensTwo() {
		List<List<String>> result = new NQueens().solveNQueens(2);
		assertNotNull(result);
		assertEquals(0, result.size());
	}
}
