package com.abotnaru.problems.neetcode;

public class ValidSudoku {

	public boolean isValidSudoku(char[][] board) {

		// 1. verify all rows
		for (int i = 0; i < 9; i++) {
			int[] occurrences = new int[9];
			for (int j = 0; j < 9; j++) {
				int index = board[i][j] - '1';
				if (index >= 0) {
					occurrences[index]++;
					if (occurrences[index] > 1) {
						return false;
					}
				}
			}
		}

		// 2. verify all columns
		for (int i = 0; i < 9; i++) {
			int[] occurrences = new int[9];
			for (int j = 0; j < 9; j++) {
				int index = board[j][i] - '1';
				if (index >= 0) {
					occurrences[index]++;
					if (occurrences[index] > 1) {
						return false;
					}
				}
			}
		}

		// 3. verify all sub-boxes
		for (int bi = 0; bi < 3; bi++) {
			for (int bj = 0; bj < 3; bj++) {

				int[] occurrences = new int[9];
				for (int i = bi * 3; i < bi * 3 + 3; i++) {
					for (int j = bj * 3; j < bj * 3 + 3; j++) {
						int index = board[i][j] - '1';
						if (index >= 0) {
							occurrences[index]++;
							if (occurrences[index] > 1) {
								return false;
							}
						}
					}
				}

			}
		}

		return true;
	}
}
