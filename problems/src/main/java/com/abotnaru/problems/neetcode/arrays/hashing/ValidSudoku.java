package com.abotnaru.problems.neetcode.arrays.hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidSudoku {

	/**
	 * Determine if a 9x9 Sudoku board is valid. Validates only filled cells
	 * according to the following rules:<br>
	 * 1. Each row must contain the digits 1-9 without repetition.<br>
	 * 2. Each column must contain the digits 1-9 without repetition.<br>
	 * 3. Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9
	 * without repetition.<br>
	 * 
	 * @param board
	 * @return
	 */
	public boolean isValidSudoku(char[][] board) {
		// Maps for row, column, and sub-boxes validation
		// The key will be the number in the cell, the value is a Set that must contain
		// unique position in the row, column, and sub-box
		Map<Character, Set<Integer>> rowsMap = new HashMap<>();
		Map<Character, Set<Integer>> colsMap = new HashMap<>();
		Map<Character, Set<Integer>> boxesMap = new HashMap<>();

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {

				if (board[i][j] == '.') {
					// if cell is no filled, skip it
					continue;
				}

				// Initialize the key value if necessary
				char key = board[i][j];
				rowsMap.computeIfAbsent(key, k -> new HashSet<>());
				colsMap.computeIfAbsent(key, k -> new HashSet<>());
				boxesMap.computeIfAbsent(key, k -> new HashSet<>());

				if (!rowsMap.get(key).add(i)) {
					// The number is already contained at the row i
					return false;
				}

				if (!colsMap.get(key).add(j)) {
					// The number is already contained at the column j
					return false;
				}

				int boxIndex = (i / 3 * 3) + (j / 3); // compute the index of the box
				if (!boxesMap.get(key).add(boxIndex)) {
					// The number is already contained in the box at boxIndex
					return false;
				}
			}

		}

		return true;
	}
}
