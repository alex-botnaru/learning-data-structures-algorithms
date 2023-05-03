package com.abotnaru.problems.neetcode.dynamic.programming.d2;

import java.util.Arrays;

public class MatrixLongestIncreasingPath {

	/**
	 * Returns the length of the longest increasing path in the matrix
	 * 
	 * @param matrix
	 * @return
	 */
	public int longestIncreasingPath(int[][] matrix) {

		// Create a cache matrix, alternatively this can be a map
		int[][] cache = new int[matrix.length][matrix[0].length];

		int maxPath = 0;

		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[0].length; col++) {
				// Iterate through each element, call DFS function and update the longest path
				maxPath = Math.max(maxPath, dfsHelper(matrix, cache, -1, row, col));
			}
		}

		return maxPath;
	}

	/**
	 * DFS helper function with memoization.
	 * 
	 * @param matrix
	 * @param cache
	 * @param prevValue
	 * @param row
	 * @param col
	 * @return
	 */
	private int dfsHelper(int[][] matrix, int[][] cache, int prevValue, int row, int col) {
		// Return 0 if out of bounds
		if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length || matrix[row][col] <= prevValue) {
			return 0;
		}

		// return cached value if exist
		if (cache[row][col] > 0) {
			return cache[row][col];
		}

		// Call dfs on neighbors and update the result to max computed value
		int result = 1;
		result = Math.max(result, 1 + dfsHelper(matrix, cache, matrix[row][col], row + 1, col));
		result = Math.max(result, 1 + dfsHelper(matrix, cache, matrix[row][col], row - 1, col));
		result = Math.max(result, 1 + dfsHelper(matrix, cache, matrix[row][col], row, col + 1));
		result = Math.max(result, 1 + dfsHelper(matrix, cache, matrix[row][col], row, col - 1));
		cache[row][col] = result;
		return result;
	}
}
