package com.abotnaru.problems.neetcode.tries;

/**
 * Class to add and search words
 *
 */
public class WordDictionary {

	private TrieNode root = new TrieNode();

	/**
	 * Add a word
	 * 
	 * @param word
	 */
	public void addWord(String word) {
		TrieNode current = root;

		for (char c : word.toLowerCase().toCharArray()) {
			current.children.computeIfAbsent(c, k -> new TrieNode());
			current = current.children.get(c);
		}

		current.isWordEnd = true;
	}

	/**
	 * Searches a word
	 * 
	 * @param word
	 * @return
	 */
	public boolean search(String word) {
		return searchHelper(root, word, 0);
	}

	/**
	 * Recursive helper method
	 * 
	 * @param current
	 * @param word
	 * @param index
	 * @return
	 */
	private boolean searchHelper(TrieNode current, String word, int index) {

		for (int i = index; current != null && i < word.length(); i++) {
			char ch = word.charAt(i);

			if (ch == '.') {
				// If we have a dot, do a recursive call through all available children
				for (TrieNode node : current.children.values()) {
					if (searchHelper(node, word, i + 1)) {
						return true;
					}
				}
				return false;
			}

			current = current.children.get(ch);
		}
		return current != null && current.isWordEnd;
	}
}
