package com.abotnaru.problems.neetcode.arrays.hashing;

import java.util.Locale;

public class ValidAnagram {

	/**
	 * Returns true if wordTwo is anagram of wordOne, false otherwise.<br>
	 * Time and space complexity is O(s + t) where s is wordOne length and t is
	 * wordTwo length respectively. The space complexity may be reduced to O(1), but
	 * the time complexity will increase as we need to sort the letters.
	 * <p>
	 * Assuming only letters from the English alphabet, no spaces.<br>
	 * 
	 * @param wordOne
	 * @param wordTwo
	 * @return
	 */
	public boolean isValidAnagram(String wordOne, String wordTwo) {
		if (wordOne == null || wordTwo == null || wordOne.length() != wordTwo.length()) {
			return false;
		} else {
			int[] letterCountWordOne = countLetters(wordOne);
			int[] letterCountWordTwo = countLetters(wordTwo);

			for (int i = 0; i < letterCountWordOne.length; i++) {
				if (letterCountWordOne[i] != letterCountWordTwo[i]) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Counts the occurrences of letters in a word. Stores the counts in an array,
	 * where each index represents a specific letter.
	 * <p>
	 * - the word will be converted to lower case<br>
	 * - alternatively to the array, a Hash Map can be used, in this case different
	 * Unicode characters can be supported.
	 * 
	 * @param word
	 * @return
	 */
	private int[] countLetters(String word) {
		int[] letterCount = new int[26];
		for (char ch : word.toLowerCase(Locale.getDefault()).toCharArray()) {
			int index = ch - 'a';
			letterCount[index]++;
		}
		return letterCount;
	}
}
