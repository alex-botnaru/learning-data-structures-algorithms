package com.abotnaru.problems.neetcode.dynamic.programming.d2;

import java.util.HashMap;
import java.util.Map;

public class InterleavingString {

	/**
	 * Returns true if interleaving strings s1 and s2 we get s3, false otherwise.
	 * <p>
	 * Dynamic programming approach
	 * 
	 * @param s1
	 * @param s2
	 * @param s3
	 * @return
	 */
	public boolean isInterleave(String s1, String s2, String s3) {

		if (s1.length() + s2.length() != s3.length()) {
			return false;
		}

		// Initialize the dp cache, 2D matrix
		boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
		dp[s1.length()][s2.length()] = true;

		// Computing bottom - up
		for (int i = s1.length(); i > -1; i--) {
			for (int j = s2.length(); j > -1; j--) {
				// If char from s1 is equal to the char in s3, and the value from the bottom is
				// true
				if (i < s1.length() && s1.charAt(i) == s3.charAt(i + j) && dp[i + 1][j]) {
					dp[i][j] = true;
				}

				// if char from s2 is equal to char in s3, and cached value from the right is
				// true
				if (j < s2.length() && s2.charAt(j) == s3.charAt(i + j) && dp[i][j + 1]) {
					dp[i][j] = true;
				}
			}
		}

		return dp[0][0];

	}

	/**
	 * Memoization solution approach
	 * 
	 * @param s1
	 * @param s2
	 * @param s3
	 * @return
	 */
	public boolean isInterleaveMemo(String s1, String s2, String s3) {
		return dfsMemoization(s1, s2, s3, new HashMap<>(), 0, 0);
	}

	private boolean dfsMemoization(String s1, String s2, String s3, Map<String, Boolean> cache, int i, int j) {
		if (i == s1.length() || j == s2.length()) {
			return true;
		}

		String key = i + "-" + j;
		if (cache.containsKey(key)) {
			return cache.get(key);
		}

		if (i < s1.length() && s1.charAt(i) == s3.charAt(i + j) && dfsMemoization(s1, s2, s3, cache, i + 1, j)) {
			return true;
		}

		if (j < s2.length() && s2.charAt(j) == s3.charAt(i + j) && dfsMemoization(s1, s2, s3, cache, i, j + 1)) {
			return true;
		}

		cache.put(key, false);
		return false;
	}
}
