package com.abotnaru.problems.neetcode.dynamic.programming.d2;

public class LongestCommonSubsequence {

	/**
	 * Returns the length of the longest common subsequence between two texts
	 * 
	 * @param text1
	 * @param text2
	 * @return
	 */
	public int longestCommonSubsequence(String text1, String text2) {
		// Initialize cache - 2D matrix
		int[][] matrix = new int[text1.length() + 1][text2.length() + 1];

		// Iterate from bottom to top and compute values
		for (int i = text1.length() - 1; i > -1; i--) {
			for (int j = text2.length() - 1; j > -1; j--) {
				if (text1.charAt(i) == text2.charAt(j)) {
					// If characters at position matches, take the diagonal value and add one
					matrix[i][j] = 1 + matrix[i + 1][j + 1];
				} else {
					// If characters don't match, take max between bottom and right
					matrix[i][j] = Math.max(matrix[i][j + 1], matrix[i + 1][j]);
				}
			}
		}
		// The top-left value has the result
		return matrix[0][0];
	}
}
