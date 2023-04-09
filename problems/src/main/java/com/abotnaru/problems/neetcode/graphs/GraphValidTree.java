package com.abotnaru.problems.neetcode.graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GraphValidTree {

	/**
	 * Returns true if a list on undirected edges create a valid tree, false
	 * otherwise.
	 * 
	 * @param n
	 * @param edges
	 * @return
	 */
	public boolean validTree(int n, int[][] edges) {
		// base case: no nodes or only one node
		if (n == 0 || n == 1) {
			return true;
		}

		Map<Integer, Set<Integer>> graph = new HashMap<>();
		Set<Integer> visited = new HashSet<>();
		// Create an adjacency list graph, each node points to each other
		for (int i = 0; i < n; i++) {
			graph.put(i, new HashSet<>());
		}

		for (int[] edge : edges) {
			graph.get(edge[0]).add(edge[1]);
			graph.get(edge[1]).add(edge[0]);
		}

		// Two condition for the graph to be a valid tree
		// 1. every node must be connected
		// 2. no cycles
		return dfsHelper(graph, visited, 0, -1) && visited.size() == n;
	}

	/**
	 * DFS helper method
	 * 
	 * @param graph
	 * @param visited
	 * @param node
	 * @param previous
	 * @return
	 */
	private boolean dfsHelper(Map<Integer, Set<Integer>> graph, Set<Integer> visited, int node, int previous) {
		// If note already visited, it means we have a cycle
		if (visited.contains(node)) {
			return false;
		}

		visited.add(node);
		for (int neighbor : graph.get(node)) {
			// Check neighbors except the previous node we came from
			if (neighbor == previous) {
				continue;
			}
			// Return immediately if a cycle was detected
			if (!dfsHelper(graph, visited, neighbor, node)) {
				return false;
			}
		}
		return true;
	}

}
