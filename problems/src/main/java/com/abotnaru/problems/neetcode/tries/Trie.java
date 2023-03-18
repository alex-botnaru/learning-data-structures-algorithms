package com.abotnaru.problems.neetcode.tries;

/**
 * Trie (Prefix Tree) Implementation.
 *
 */
public class Trie {

	TrieNode root = new TrieNode();

	/**
	 * Inserts a word in the trie
	 * 
	 * @param word
	 */
	public void insert(String word) {
		TrieNode current = root;

		for (char c : word.toLowerCase().toCharArray()) {
			current.map.computeIfAbsent(c, k -> new TrieNode());
			current = current.map.get(c);
		}

		current.isWordEnd = true;
	}

	/**
	 * Searches for a full word in the trie, returns true if the word exist, false
	 * otherwise.
	 * 
	 * @param word
	 * @return
	 */
	public boolean search(String word) {
		TrieNode current = root;
		for (char c : word.toLowerCase().toCharArray()) {
			current = current.map.get(c);
			if (current == null) {
				break;
			}
		}
		return current != null && current.isWordEnd;
	}

	/**
	 * Returns true if the trie contains a word that starts with the prefix, false
	 * otherwise.
	 * 
	 * @param prefix
	 * @return
	 */
	public boolean startsWith(String prefix) {
		TrieNode current = root;
		for (char c : prefix.toLowerCase().toCharArray()) {
			current = current.map.get(c);
			if (current == null) {
				break;
			}
		}
		return current != null;
	}
}
