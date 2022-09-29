package com.abotnaru.problems.neetcode;

import java.util.ArrayList;
import java.util.List;

public class EncodeDecodeString {

	private static final char DELIMITER = '#';

	/**
	 * Encodes a list of strings into a string.
	 * <p>
	 * My initial solution is to have a predefined delimiter. But this won't work in
	 * case if one of the words in the list already contains the delimiter.
	 * <p>
	 * The video solution is to have the number of characters in the word,
	 * delimiter, and then the word.<br>
	 * This will help, since we know how many characters the word contains, even if
	 * it contains a number + delimiter. A word always will start with a number and
	 * delimiter in the encoded string. <br>
	 * The complexity of both methods should be O(N*S) where N is number of words, S
	 * is max length of a word.
	 * 
	 * @param list
	 * @return
	 */
	public String encode(List<String> strings) {
		StringBuilder builder = new StringBuilder();
		for (String string : strings) {
			builder.append(string.length()).append(DELIMITER).append(string);
		}
		return builder.toString();
	}

	/**
	 * Decodes a string into a list of strings
	 * <p>
	 * 
	 * @param input
	 * @return
	 */
	public List<String> decode(String input) {
		List<String> list = new ArrayList<>();
		int i = 0;
		while (i < input.length()) {
			int j = i;
			// Iterate until the delimiter is found
			while (input.charAt(j) != DELIMITER)
				j++;
			// We know that the i to j substring is a number that represents the word length
			int stringLength = Integer.parseInt(input.substring(i, j));
			i = j + 1 + stringLength;
			list.add(input.substring(j + 1, i));
		}
		return list;
	}

}
