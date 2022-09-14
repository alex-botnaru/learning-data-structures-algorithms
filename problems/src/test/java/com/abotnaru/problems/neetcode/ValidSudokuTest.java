package com.abotnaru.problems.neetcode;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ValidSudokuTest {

	/**
	 * 1. Kind of brute force approach: <br>
	 * a) Iterate through each row<br>
	 * b) Iterate through each column<br>
	 * c) Iterate through each 3x3 boxes<br>
	 * For each iteration, store the number of occurrences in an array. If at least
	 * one occurrence is greater than 1, return false immediately.
	 * <p>
	 * 2. There are 9 rows, 9 columns, and 9 sub-boxes.<br>
	 * Use three maps, one for rows, one for columns, and one for sub-boxes. The key
	 * will be the number, the value will be a set.<br>
	 * If adding a number to the set returns false, it means there is a duplicate -
	 * return false. <br>
	 * For sub-boxes, compute the sub-box index based on row and column index.<br>
	 * Instead of maps, arrays also can be used.
	 */

	private static final char[][] VALID_BOARD = new char[][] {
		{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
		{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
		{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
		{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
		{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
		{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
		{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
		{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
		{'.', '.', '.', '.', '8', '.', '.', '7', '9'}
	};
	
	private static final char[][] INVALID_BOARD_ROW = new char[][] {
		{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
		{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
		{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
		{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
		{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
		{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
		{'2', '6', '.', '.', '.', '.', '2', '8', '.'},
		{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
		{'.', '.', '.', '.', '8', '.', '.', '7', '9'}
	};
	
	private static final char[][] INVALID_BOARD_COL = new char[][] {
		{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
		{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
		{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
		{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
		{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
		{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
		{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
		{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
		{'.', '3', '.', '.', '8', '.', '.', '7', '9'}
	};
	
	private static final char[][] INVALID_BOARD_SUB_BOX = new char[][] {
		{'9', '3', '.', '.', '7', '.', '.', '.', '.'},
		{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
		{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
		{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
		{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
		{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
		{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
		{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
		{'.', '.', '.', '.', '8', '.', '.', '7', '9'}
	};

	@Test
	void testValidSudokuBoard() {
		assertTrue(new ValidSudoku().isValidSudoku(VALID_BOARD));
	}

	@Test
	void testInvalidRowSudokuBoard() {
		assertFalse(new ValidSudoku().isValidSudoku(INVALID_BOARD_ROW));
	}

	@Test
	void testInvalidColumnSudokuBoard() {
		assertFalse(new ValidSudoku().isValidSudoku(INVALID_BOARD_COL));
	}

	@Test
	void testInvalidSubBoxSudokuBoard() {
		assertFalse(new ValidSudoku().isValidSudoku(INVALID_BOARD_SUB_BOX));
	}
}
