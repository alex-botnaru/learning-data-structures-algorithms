package com.abotnaru.problems.neetcode.backtracking;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class WordSearchTest {

	final char[][] board = new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };

	@Test
	void testWordABCCEDExistsExpectTrue() {
		assertTrue(new WordSearch().exist(board, "ABCCED"));
	}

	@Test
	void testWordSEEExistsExpectTrue() {
		assertTrue(new WordSearch().exist(board, "SEE"));
	}

	@Test
	void testWordABCBExistsExpectTrue() {
		assertFalse(new WordSearch().exist(board, "ABCB"));
	}

}
