package com.abotnaru.problems.neetcode.arrays.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

	/**
	 * Groups the strings into anagram groups.
	 * <p>
	 * The time complexity of this is O(W*S), where W represents the number of words
	 * in the array and S the max word length.
	 * 
	 * @param strs
	 * @return
	 */
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> result = new ArrayList<>();
		Map<String, List<String>> anagramsMap = new HashMap<>();

		for (String str : strs) {
			String key = buildAnagramKey(str);
			anagramsMap.computeIfAbsent(key, k -> new ArrayList<>());
			anagramsMap.get(key).add(str);
		}

		result.addAll(anagramsMap.values());
		return result;
	}

	/**
	 * Creates the anagram key from the specified string.<br>
	 * Time complexity is O(S), where S is str length.
	 * 
	 * @param str
	 * @return
	 */
	private String buildAnagramKey(String str) {
		char[] lettersCount = new char[26];
		for (char c : str.toCharArray()) {
			lettersCount[c - 'a']++;
		}
		return new String(lettersCount);
	}
}
