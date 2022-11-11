package com.abotnaru.problems.neetcode.sliding.window;

import java.util.HashMap;
import java.util.Map;

public class PermutationInString {

	/**
	 * Returns true if s2 contains a permutation of s1, false otherwise.
	 * <p>
	 * Optimized solution. Time complexity is O(S2) where S2 is the length of s2
	 * string
	 * 
	 * @param s1
	 * @param s2
	 * @return
	 */
	public Object checkInclusion(String s1, String s2) {

		if (s1.length() > s2.length())
			return false;

		int left = 0;
		int right = 0;
		int[] s1Map = new int[26];
		int[] s2Map = new int[26];

		// calculate the number of occurrences for first s1.length characters
		for (; right < s1.length(); right++) {
			s1Map[s1.charAt(right) - 'a']++;
			s2Map[s2.charAt(right) - 'a']++;
		}

		// count how many characters match the occurrences
		int matches = 0;
		for (int i = 0; i < 26; i++) {
			if (s1Map[i] == s2Map[i]) {
				matches++;
			}
		}

		// Shift the window to the right by one character
		for (; right < s2.length(); right++) {

			if (matches == 26)
				return true;

			// Adding one character to the window
			int index = s2.charAt(right) - 'a';
			s2Map[index]++;
			if (s1Map[index] == s2Map[index]) {
				matches++;
			} else if (s1Map[index] + 1 == s2Map[index]) {
				// The element in the s2Map was just incremented by one. If the previous value
				// was equal with the value from s1Map, and now is larger, we decrement the
				// matches.
				matches--;
			}

			// Removing the left character from the window
			index = s2.charAt(left) - 'a';
			s2Map[index]--;
			if (s1Map[index] == s2Map[index]) {
				matches++;
			} else if (s1Map[index] - 1 == s2Map[index]) {
				// The element in the s2Map was just decremented by one. If the previous value
				// was equal with the value from s1Map, and now is smaller, we decrement the
				// matches.
				matches--;
			}
			left++;

		}

		return matches == 26;
	}

	/**
	 * Returns true if s2 contains a permutation of s1, false otherwise.
	 * <p>
	 * This is initial solution. Time complexity O(S1 S2), space complexity O(S1),
	 * where S1 is length of s1 string and S2 is the length of s2 string
	 * respectively
	 * 
	 * @param s1
	 * @param s2
	 * @return
	 */
	public Object checkInclusionInitial(String s1, String s2) {

		if (s1.length() > s2.length())
			return false;

		int left = 0;
		int right = s1.length();

		Map<Character, Integer> s1Map = new HashMap<>();
		for (char c : s1.toCharArray()) {
			s1Map.put(c, s1Map.getOrDefault(c, 0) + 1);
		}

		while (right < s2.length()) {
			Map<Character, Integer> tempMap = new HashMap<>();
			for (char c : s2.substring(left, right).toCharArray()) {
				tempMap.put(c, tempMap.getOrDefault(c, 0) + 1);
			}
			boolean isPermutation = true;
			for (char c : s1.toCharArray()) {
				isPermutation &= s1Map.get(c).equals(tempMap.get(c));
			}

			if (isPermutation)
				return true;
			left++;
			right++;
		}

		return false;
	}

}
