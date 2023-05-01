package com.abotnaru.problems.neetcode.dynamic.programming.d2;

import java.util.Arrays;

public class UniquePaths {

	/**
	 * Returns the number of possible paths from top-left to bottom-right in an MxN
	 * matrix.
	 * <p>
	 * Optimized, O(N) space complexity and O(MxN) time complexity
	 * 
	 * @param m
	 * @param n
	 * @return
	 */
	public int uniquePaths(int m, int n) {
		// Initialize bottom row with "1", since there is only one path to get to the
		// right.
		int[] row = new int[n];
		Arrays.fill(row, 1);

		for (int i = m - 2; i > -1; i--) {
			// Moving upwards, the last element in the row always will be 1.
			for (int j = n - 2; j > -1; j--) {
				// Compute the value of the next row
				row[j] += row[j + 1];
			}
		}

		return row[0];
	}

	/**
	 * O(MxN) space and time complexity.
	 * 
	 * @param m
	 * @param n
	 * @return
	 */
	public int uniquePathsWithMatrix(int m, int n) {
		int[][] matrix = new int[m][n];

		for (int i = 0; i < m; i++) {
			matrix[i][n - 1] = 1;
		}

		for (int i = 0; i < n; i++) {
			matrix[m - 1][i] = 1;
		}

		for (int i = m - 2; i > -1; i--) {
			for (int j = n - 2; j > -1; j--) {
				matrix[i][j] = matrix[i + 1][j] + matrix[i][j + 1];
			}
		}

		return matrix[0][0];
	}
}
