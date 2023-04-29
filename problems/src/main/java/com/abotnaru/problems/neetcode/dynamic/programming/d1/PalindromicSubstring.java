package com.abotnaru.problems.neetcode.dynamic.programming.d1;

public class PalindromicSubstring {

	/**
	 * Returns the number of palindromic substrings in the provided string.
	 * 
	 * @param s
	 * @return
	 */
	public int countSubstrings(String s) {
		int count = 0;
		// Consider each character as possible middle of palindrome
		for (int i = 0; i < s.length(); i++) {
			// Odd length case
			count += expandMiddle(s, i, i);

			// Even length case
			count += expandMiddle(s, i, i + 1);
		}
		return count;
	}

	/**
	 * Helper method to expand from the specified left and right indexes and count
	 * all possible palindromes.
	 * 
	 * @param s
	 * @param left
	 * @param right
	 * @return
	 */
	private int expandMiddle(String s, int left, int right) {
		int count = 0;
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			// as we expand left and right and the characters are equal, update the count
			// and indexes
			count++;
			left--;
			right++;
		}
		return count;
	}
}
