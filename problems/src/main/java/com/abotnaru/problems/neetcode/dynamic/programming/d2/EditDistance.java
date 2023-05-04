package com.abotnaru.problems.neetcode.dynamic.programming.d2;

public class EditDistance {

	/**
	 * Returns the minimum number of operations required to convert word1 to word2
	 * 
	 * @param word1
	 * @param word2
	 * @return
	 */
	public int minDistance(String word1, String word2) {
		int[][] cache = new int[word1.length() + 1][word2.length() + 1];

		// Fill default values for bottom row
		for (int j = 0; j < word2.length() + 1; j++) {
			cache[word1.length()][j] = word2.length() - j;
		}

		// Fill default values for last column
		for (int i = 0; i < word1.length() + 1; i++) {
			cache[i][word2.length()] = word1.length() - i;
		}

		// Computing values from bottom-up
		for (int i = word1.length() - 1; i > -1; i--) {
			for (int j = word2.length() - 1; j > -1; j--) {
				if (word1.charAt(i) == word2.charAt(j)) {
					// Characters match, no operation necessary, just copy diagonal value
					cache[i][j] = cache[i + 1][j + 1];
				} else {
					// else, try all operation: insert(i, j + 1), delete(i + 1, j), replace(i + 1, j
					// + 1)
					cache[i][j] = 1 + Math.min(cache[i + 1][j], Math.min(cache[i][j + 1], cache[i + 1][j + 1]));
				}
			}
		}

		return cache[0][0];
	}
}
