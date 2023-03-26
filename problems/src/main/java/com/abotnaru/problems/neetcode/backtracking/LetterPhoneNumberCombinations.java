package com.abotnaru.problems.neetcode.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LetterPhoneNumberCombinations {

	private static final Map<Integer, Set<Character>> numberLettersMap = Map.of(2, Set.of('a', 'b', 'c'), 3,
			Set.of('d', 'e', 'f'), 4, Set.of('g', 'h', 'i'), 5, Set.of('j', 'k', 'l'), 6, Set.of('m', 'n', 'o'), 7,
			Set.of('p', 'q', 'r', 's'), 8, Set.of('t', 'u', 'v'), 9, Set.of('w', 'x', 'y', 'z'));

	/**
	 * Returns all possible letter combinations that a number could represent
	 * 
	 * @param digits
	 * @return
	 */
	public List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<>();
		if (!digits.isEmpty()) {
			backtackHelper(digits, result, "");
		}
		return result;
	}

	/**
	 * Backtracking helper method
	 * 
	 * @param digits
	 * @param result
	 * @param word
	 */
	private void backtackHelper(String digits, List<String> result, String word) {
		if (word.length() == digits.length()) {
			// if the word has the same length as the digits string, we have a complete
			// possible combination
			result.add(word);
		} else {
			int index = word.length(); // get the index for the next digit
			// Get all possible letters for the next digit and make a recursive call.
			for (char c : numberLettersMap.get(digits.charAt(index) - '0')) {
				backtackHelper(digits, result, word + c);
			}
		}
	}
}
