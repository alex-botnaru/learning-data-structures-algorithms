package com.abotnaru.problems.neetcode.sliding.window;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

	/**
	 * For the given string, find the length of the longest substring without
	 * repeating characters.
	 * 
	 * @param string
	 * @return
	 */
	public int lengthOfLongestSubstring(String string) {
		Set<Character> charSet = new HashSet<>();
		int longestSubstring = 0;
		int left = 0;
		for (int right = 0; right < string.length(); right++) {

			// Shift the left pointer until the duplicate character is removed
			while (charSet.contains(string.charAt(right))) {
				charSet.remove(string.charAt(left));
				left++;
			}
			// Add the current character to the set and compute the max length
			charSet.add(string.charAt(right));
			longestSubstring = Math.max(longestSubstring, right - left + 1);
		}

		longestSubstring = Math.max(longestSubstring, charSet.size());
		return longestSubstring;
	}

}
