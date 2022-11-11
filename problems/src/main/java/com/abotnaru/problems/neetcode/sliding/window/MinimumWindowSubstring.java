package com.abotnaru.problems.neetcode.sliding.window;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

	/**
	 * Returns the "MInimum Window Substring" of s such that every character in t
	 * (including duplicates) is included in the window. If there is no such
	 * substring, return the empty string.
	 * <p>
	 * Time complexity O(M + N), Space complexity O(N), where M is length of s, and
	 * N is length of t.
	 * <p>
	 * NOTE: The java solution from Neetcode.io contains a bug when t has repeated
	 * characters.
	 * 
	 * @param s
	 * @param t
	 * @return
	 */
	public String minWindow(String s, String t) {

		Map<Character, Integer> tMap = new HashMap<>(); // Map to store character occurrences from t
		Map<Character, Integer> sMap = new HashMap<>(); // Map to store required character occurrences in window
		for (char c : t.toCharArray()) {
			tMap.put(c, tMap.getOrDefault(c, 0) + 1);
			sMap.putIfAbsent(c, 0);
		}

		int left = 0;
		int matched = 0;
		int start = 0;
		int minLength = s.length() + 1; // Set minLenght as max as possible

		// Expand the window to the right
		for (int right = 0; right < s.length(); right++) {
			char c = s.charAt(right);
			if (tMap.containsKey(c)) {
				// Increment the found character
				sMap.put(c, sMap.get(c) + 1);
				// Increment the matched characters
				if (sMap.get(c) <= tMap.get(c)) {
					matched++;
				}
			}

			c = s.charAt(left);
			// Shrink the window from the left as long it contains required characters
			while (!tMap.containsKey(c) || sMap.get(c) > tMap.get(c)) {
				// this internal loop will run only M times
				left++;
				if (sMap.containsKey(c)) {
					sMap.put(c, sMap.get(c) - 1);
				}
				c = s.charAt(left);
			}

			// Update the minimum window size
			if (matched == t.length() && (minLength > (right - left + 1))) {
				minLength = right - left + 1;
				start = left;
			}
		}

		return minLength > s.length() ? "" : s.substring(start, start + minLength);
	}

}
