package com.abotnaru.problems.neetcode.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NQueens {

	/**
	 * Return all possible answers to the puzzle when placing n queen into an n x n
	 * grid.
	 * 
	 * @param n
	 * @return
	 */
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> result = new ArrayList<>();
		Set<Integer> cols = new HashSet<>();
		Set<Integer> lrDiag = new HashSet<>(); // row - col
		Set<Integer> rlDiag = new HashSet<>(); // row + col
		char[][] board = new char[n][n];
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < n; col++) {
				board[row][col] = '.';
			}
		}
		backtrackQueens(board, result, cols, lrDiag, rlDiag, 0);

		return result;
	}

	/**
	 * Backtracking helper method
	 * 
	 * @param board
	 * @param result
	 * @param cols
	 * @param lrDiag
	 * @param rlDiag
	 * @param row
	 */
	private void backtrackQueens(char[][] board, List<List<String>> result, Set<Integer> cols, Set<Integer> lrDiag,
			Set<Integer> rlDiag, int row) {

		// We reach the end, a possible combination, create a possible result
		if (row == board.length) {
			result.add(createResult(board));
			return;
		}

		for (int col = 0; col < board[0].length; col++) {
			if (cols.contains(col) || lrDiag.contains(row - col) || rlDiag.contains(row + col)) {
				// Queen cannot be placed if another queen is on the same column and both
				// diagonals
				continue;
			}
			// Place the queen
			board[row][col] = 'Q';
			cols.add(col);
			lrDiag.add(row - col);
			rlDiag.add(row + col);
			// Check next row
			backtrackQueens(board, result, cols, lrDiag, rlDiag, row + 1);
			// Remove the queen
			cols.remove(col);
			lrDiag.remove(row - col);
			rlDiag.remove(row + col);
			board[row][col] = '.';
		}

	}

	/**
	 * Helper method to build a possible answer
	 * 
	 * @param board
	 * @return
	 */
	private List<String> createResult(char[][] board) {
		List<String> list = new ArrayList<>();
		for (int row = 0; row < board.length; row++) {
			StringBuilder rowStr = new StringBuilder();
			for (int col = 0; col < board[0].length; col++) {
				rowStr.append(board[row][col]);
			}
			list.add(rowStr.toString());
		}
		return list;
	}
}
