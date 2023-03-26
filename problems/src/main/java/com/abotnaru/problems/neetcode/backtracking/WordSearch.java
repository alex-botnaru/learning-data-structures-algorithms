package com.abotnaru.problems.neetcode.backtracking;

public class WordSearch {

	/**
	 * Returns true if the word exists in the provided board, false otherwise.
	 */
	public boolean exist(char[][] board, String word) {
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[0].length; col++) {
				if (isWordInBoard(board, word, 0, row, col)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean isWordInBoard(char[][] board, String word, int index, int row, int col) {
		// Check if out of bound, or a character mismatch
		if (row < 0 || col < 0 || row >= board.length || col >= board[0].length
				|| board[row][col] != word.charAt(index)) {
			return false;
		}

		index++;
		// Reach the end of the word, return true
		if (index == word.length()) {
			return true;
		}
		// Current node contains a character from the word, check if neighbors contain
		// the next one
		boolean wordExists = false;
		board[row][col] += 100; // one way to mark a char node as visited
		wordExists |= isWordInBoard(board, word, index, row + 1, col);
		wordExists |= isWordInBoard(board, word, index, row - 1, col);
		wordExists |= isWordInBoard(board, word, index, row, col + 1);
		wordExists |= isWordInBoard(board, word, index, row, col - 1);
		board[row][col] -= 100;
		return wordExists;
	}
}
