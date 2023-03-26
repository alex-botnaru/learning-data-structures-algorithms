package com.abotnaru.problems.neetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

	/**
	 * Returns all possible palindrome partitioning of s
	 * 
	 * @param s
	 * @return
	 */
	public List<List<String>> partition(String s) {
		List<List<String>> result = new ArrayList<>();

		if (s.isEmpty()) {
			// Edge case of recursive call, when string is empty just create an empty list
			result.add(new ArrayList<>());
			return result;
		}

		for (int i = 0; i < s.length(); i++) {
			if (isPalindrome(s, i + 1)) {
				// If the first part of the string is palindrome, recursively call this method
				// for the rest of the string
				for (List<String> list : partition(s.substring(i + 1))) {
					list.add(0, s.substring(0, i + 1));
					result.add(list);
				}
			}
		}

		return result;
	}

	// Helper method to check if a string beginning is a palindrome or not
	private boolean isPalindrome(String string, int end) {
		int left = 0;
		int right = end - 1;
		while (left < end) {
			if (string.charAt(left) != string.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
}
