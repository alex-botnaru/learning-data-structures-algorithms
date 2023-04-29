package com.abotnaru.problems.neetcode.dynamic.programming.d1;

public class LongestPalindromicSubstring {

	/**
	 * Returns the longest palindromic substring in s.
	 * 
	 * @param s
	 * @return
	 */
	public String longestPalindrome(String s) {
		String result = "";

		// Consider each character as possible middle of palindrome
		for (int i = 0; i < s.length(); i++) {
			// Odd length case
			result = expandMiddle(s, result, i, i);

			// Even length case
			result = expandMiddle(s, result, i, i + 1);
		}
		return result;
	}

	/**
	 * Helper function to find the longest palindrome substring expanding from
	 * specified left and right indexes.
	 * 
	 * @param s
	 * @param current
	 * @param left
	 * @param right
	 * @return
	 */
	private String expandMiddle(String s, String current, int left, int right) {
		String result = current;
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			if ((right - left + 1) > result.length()) {
				result = s.substring(left, right + 1);
			}
			left--;
			right++;
		}
		return result;
	}
}
