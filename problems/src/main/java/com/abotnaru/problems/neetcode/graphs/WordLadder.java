package com.abotnaru.problems.neetcode.graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

	/**
	 * Returns the number of steps to transform the beginning word to the end word,
	 * by one character at the time using words from the list. Returns 0 if that is
	 * not possible.
	 * 
	 * @param beginWord
	 * @param endWord
	 * @param wordList
	 * @return
	 */
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {

		Map<String, Set<String>> graph = new HashMap<>();
		Set<String> allWords = new HashSet<>(wordList);
		allWords.add(beginWord); // wordList may not contain beginWord and the wordList may be immutable
		// Create the graph
		for (String word : allWords) {
			// The key consists of masking one character, and the value is a set of words
			// for that mask that differ on one character
			for (int i = 0; i < word.length(); i++) {
				StringBuilder key = new StringBuilder(word);
				key.setCharAt(i, '.');
				graph.computeIfAbsent(key.toString(), k -> new HashSet<>()).add(word);
			}
		}

		Queue<String> queue = new PriorityQueue<>();
		Set<String> visited = new HashSet<>();
		queue.add(beginWord);
		visited.add(beginWord);
		int result = 1;

		// Using BFS to detect the shortest path

		while (!queue.isEmpty()) {
			int queueLen = queue.size();
			result++;
			for (int i = 0; i < queueLen; i++) {
				// Pop n words per graph level
				String word = queue.poll();
				if (word.equals(endWord)) {
					// End word found, return immediately
					return result;
				}

				for (int j = 0; j < word.length(); j++) {
					// Get all the keys for the word
					StringBuilder key = new StringBuilder(word);
					key.setCharAt(j, '.');
					for (String neighbor : graph.get(key.toString())) {
						// Skip if visited, otherwise add them to queue and visited set
						if (!visited.contains(neighbor)) {
							visited.add(neighbor);
							queue.add(neighbor);
						}
					}
				}

			}
		}

		return 0;
	}
}
