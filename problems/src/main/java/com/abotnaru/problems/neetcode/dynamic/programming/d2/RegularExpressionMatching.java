package com.abotnaru.problems.neetcode.dynamic.programming.d2;

import java.util.HashMap;
import java.util.Map;

public class RegularExpressionMatching {

	/**
	 * Returns true if input string matches the pattern
	 * <p>
	 * Time complexity is O(NxM), where N = length of s and M = length of p
	 * 
	 * @param s
	 * @param p
	 * @return
	 */
	public boolean isMatch(String s, String p) {
		return dfs(s, p, new HashMap<>(), 0, 0);
	}

	/**
	 * DFS helper top-bottom approach with memoization
	 * 
	 * @param s
	 * @param p
	 * @param cache
	 * @param i
	 * @param j
	 * @return
	 */
	private boolean dfs(String s, String p, Map<String, Boolean> cache, int i, int j) {

		String key = i + "-" + j;
		// return cached values
		if (cache.containsKey(key)) {
			return cache.get(key);
		}

		if (i >= s.length() && j >= p.length()) {
			// Base case, reached the end of the string s and the pattern p, they are
			// matching
			return true;
		}

		if (j >= p.length()) {
			// Base case, the string s has not matched the pattern
			return false;
		}

		boolean match = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

		if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
			// Case when we choose to skip the star - (i, j + 2)
			// Case when we choose to use the start - (i + 1, j)
			cache.put(key, dfs(s, p, cache, i, j + 2) || (match && dfs(s, p, cache, i + 1, j)));
		} else if (match) {
			// Both char matches, move to next position (i+1, j+1)
			cache.put(key, dfs(s, p, cache, i + 1, j + 1));
		} else {
			// No matching, add false
			cache.put(key, false);
		}

		return cache.get(key);
	}
}
