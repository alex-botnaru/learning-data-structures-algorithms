package com.abotnaru.problems.neetcode.tries;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchII {

	public List<String> findWords(char[][] board, String[] words) {
		Set<String> result = new HashSet<>();
		TrieNode root = new TrieNode();
		Set<String> visited = new HashSet<>();

		// Add words to a trie
		for (String word : words) {
			addWordToTrie(root, word);
		}

		// Each character may be a word start, loop through each board letter and see if
		// it can lead to a word
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[0].length; col++) {
				searchWord(board, row, col, visited, root, "", result);
			}
		}

		return new ArrayList<>(result);
	}

	/**
	 * Helper method to find a word on a board
	 * 
	 * @param board
	 * @param row
	 * @param col
	 * @param visited
	 * @param node
	 * @param word
	 * @param result
	 */
	private void searchWord(char[][] board, int row, int col, Set<String> visited, TrieNode node, String word,
			Set<String> result) {

		// return if row or col is out of range, or the node is visited, or the
		// character is not a children of the current node
		if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || visited.contains(row + "-" + col)
				|| !node.children.containsKey(board[row][col])) {
			return;
		}

		// Mark the node as visited
		visited.add(row + "-" + col);
		// Get the next node in the trie
		node = node.children.get(board[row][col]);
		// Add the character to the word
		word += board[row][col];
		// And if it is the word end, add it to the results
		if (node.isWordEnd) {
			result.add(word);
		}

		// Check the neighbor characters
		searchWord(board, row + 1, col, visited, node, word, result);
		searchWord(board, row - 1, col, visited, node, word, result);
		searchWord(board, row, col + 1, visited, node, word, result);
		searchWord(board, row, col - 1, visited, node, word, result);

		// once we checked the neighbors, unmark this node as visited
		visited.remove(row + "-" + col);
	}

	/**
	 * Helper method to add a word to a trie
	 * 
	 * @param root
	 * @param word
	 */
	private void addWordToTrie(TrieNode root, String word) {
		TrieNode current = root;

		for (char c : word.toCharArray()) {
			current.children.computeIfAbsent(c, k -> new TrieNode());
			current = current.children.get(c);
		}
		current.isWordEnd = true;
	}
}
