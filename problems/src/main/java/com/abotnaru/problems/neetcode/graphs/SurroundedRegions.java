package com.abotnaru.problems.neetcode.graphs;

public class SurroundedRegions {

	/**
	 * Captures the surrounded regions by flipping all 'O' cells to 'X'
	 * 
	 * @param board
	 */
	public void solve(char[][] board) {
		final int rows = board.length;
		final int cols = board[0].length;

		for (int row = 0; row < rows; row++) {
			// Mark unsurrounded regions from left and right margins with 'T'
			dfsMarkUnsurrounded(board, row, 0);
			dfsMarkUnsurrounded(board, row, cols - 1);
		}

		for (int col = 0; col < cols; col++) {
			// Mark unsurrounded regions from top and bottom margins with 'T'
			dfsMarkUnsurrounded(board, 0, col);
			dfsMarkUnsurrounded(board, rows - 1, col);
		}

		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				if (board[row][col] == 'O') {
					// Mark 'O' cells as 'X' as they are surrounded
					board[row][col] = 'X';
				} else if (board[row][col] == 'T') {
					// Mark 'T' cells back to 'O'
					board[row][col] = 'O';
				}
			}
		}
	}

	private void dfsMarkUnsurrounded(char[][] board, int row, int col) {
		final int rows = board.length;
		final int cols = board[0].length;
		// Return if row and cols are out of bounds or is not 'O'
		if (row < 0 || row >= rows || col < 0 || col >= cols || board[row][col] != 'O') {
			return;
		}

		// temporary mark the region that cannot be surrounded
		board[row][col] = 'T';
		// Check the next cells, DFS
		dfsMarkUnsurrounded(board, row + 1, col);
		dfsMarkUnsurrounded(board, row - 1, col);
		dfsMarkUnsurrounded(board, row, col + 1);
		dfsMarkUnsurrounded(board, row, col - 1);
	}
}
