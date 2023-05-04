package com.abotnaru.problems.neetcode.dynamic.programming.d2;

import java.util.Arrays;

public class DistinctSubsequences {

	/**
	 * Returns the number of distinct subsequences of s which equals to t
	 * 
	 * @param s
	 * @param t
	 * @return
	 */
	public int numDistinct(String s, String t) {

		int[][] cache = new int[s.length()][t.length()];
		for (int[] row : cache) {
			Arrays.fill(row, -1);
		}
		return dfs(s, t, cache, 0, 0);
	}

	/**
	 * 
	 * @param s
	 * @param t
	 * @param cache
	 * @param i     - index in character s
	 * @param j     - index in character t
	 * @return
	 */
	private int dfs(String s, String t, int[][] cache, int i, int j) {

		if (j == t.length()) {
			// Reached the end of the string t
			return 1;
		}

		if (i == s.length()) {
			// Reached the end of the string s, cannot match t, return 0
			return 0;
		}

		if (cache[i][j] > -1) {
			// Return cached value
			return cache[i][j];
		}

		if (s.charAt(i) == t.charAt(j)) {
			// If character matches, consider next character in both strings, and the case
			// when we consider only the next character in string s
			cache[i][j] = dfs(s, t, cache, i + 1, j + 1) + dfs(s, t, cache, i + 1, j);
		} else {
			// Characters don't match, check next character in s
			cache[i][j] = dfs(s, t, cache, i + 1, j);
		}
		return cache[i][j];
	}
}
