package com.abotnaru.problems.neetcode.dynamic.programming.d1;

import java.util.List;

public class WordBreak {

	/**
	 * Returns true if s can be segmented into space-separated sequence of one or
	 * more dictionary words.
	 * 
	 * @param s
	 * @param wordDict
	 * @return
	 */
	public boolean wordBreak(String s, List<String> wordDict) {
		// Cache array with size s.len + 1
		boolean[] dp = new boolean[s.length() + 1];
		dp[s.length()] = true; // The last element in cache is true

		for (int i = s.length() - 1; i > -1; i--) {
			// Check each word in dictionary
			for (String word : wordDict) {
				// if starting at current position forms a word in dictionary, cache the value
				// from the previous index
				if (i + word.length() <= s.length() && word.equals(s.substring(i, i + word.length()))) {
					dp[i] = dp[i + word.length()];
				}

				// found one combination, no need to loop through remaining words
				if (dp[i]) {
					break;
				}
			}

		}

		return dp[0];
	}
}
