package com.abotnaru.problems.neetcode.advanced.graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AlienDictionary {

	/**
	 * Returns the characters sorted in alphabetical order according to the alien
	 * dictionary based on the list of input words that are sorted
	 * lexicographically. Returns empty string if order is invalid.
	 * 
	 * @param words
	 * @return
	 */
	public String alienOrder(String[] words) {

		Map<Character, Set<Character>> graph = new HashMap<>();
		StringBuilder builder = new StringBuilder();
		Map<Character, Boolean> visited = new HashMap<>(); // False - visited, True - visited and on the path

		// Build the graph
		for (int i = 0; i < words.length - 1; i++) {
			String word1 = words[i];
			String word2 = words[i + 1];
			int minLen = Math.min(word1.length(), word2.length());

			// If first word is longer than the second and the second is prefix of the
			// first, we have an invalid order, return immediately
			if (word1.length() > word2.length() && word1.startsWith(word2)) {
				return "";
			}

			for (int j = 0; j < minLen; j++) {
				if (word1.charAt(j) != word2.charAt(j)) {
					// We are interested in the first different character only
					graph.computeIfAbsent(word1.charAt(j), k -> new HashSet<>()).add(word2.charAt(j));
					graph.computeIfAbsent(word2.charAt(j), k -> new HashSet<>());
					break;
				}
			}

		}

		// Loop through each node in the map and build the order, call the DFS helper
		// method to traverse the graph in post-order
		for (char c : graph.keySet()) {
			// Return immediately if the DFS function returns true, means a cycle was
			// detected
			if (dfsHelper(graph, visited, builder, c)) {
				return "";
			}
		}

		// Reverse the letters since we build the order from last to first
		builder.reverse();
		return builder.toString();
	}

	/**
	 * Helper method to traverse the graph
	 * 
	 * @param graph
	 * @param visited
	 * @param builder
	 * @param c
	 * @return
	 */
	private boolean dfsHelper(Map<Character, Set<Character>> graph, Map<Character, Boolean> visited,
			StringBuilder builder, char c) {

		// Skip if visited, if the node is in the path it will return true and exit the
		// code.
		if (visited.containsKey(c)) {
			return visited.get(c);
		}

		// Mark the node as visited and in the path.
		visited.put(c, true);
		for (char neighbor : graph.get(c)) {
			// recursively visit neighbors, and if one of the calls returns true (violation
			// detected) return true immediately
			if (dfsHelper(graph, visited, builder, neighbor)) {
				return true;
			}
		}
		// Mark the node as visited but not in the path and append it to the builder
		visited.put(c, false);
		builder.append(c);
		return false;
	}
}
