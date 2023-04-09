package com.abotnaru.problems.neetcode.graphs;

public class ConnectedComponents {

	/**
	 * Return the number of connected components
	 * 
	 * @param nodes
	 * @param edges
	 * @return
	 */
	public int countComponents(int nodes, int[][] edges) {
		int[] parents = new int[nodes];
		int components = nodes;
		// Initialize the array, initially all nodes point at themselves
		for (int i = 0; i < parents.length; i++) {
			parents[i] = i;
		}

		for (int[] edge : edges) {
			// For each edge, if they were combined, decrement the number of components
			if (union(parents, edge[0], edge[1])) {
				components--;
			}
		}

		return components;
	}

	/**
	 * Helper function to find the top parent node
	 * 
	 * @param parents
	 * @param node
	 * @return
	 */
	private int find(int[] parents, int node) {
		int result = node;
		while (parents[result] != result) {
			parents[result] = parents[parents[result]]; // Trick path-compression
			result = parents[result];
		}
		return result;
	}

	/**
	 * Helper function to combine two nodes under the same parent, returns true if
	 * nodes were combined, or false if they previously were combined.
	 * 
	 * @param parents
	 * @param x
	 * @param y
	 * @return
	 */
	private boolean union(int[] parents, int x, int y) {
		int px = find(parents, x);
		int py = find(parents, y);

		if (px == py) {
			return false;
		}
		// an optional optimization is to have a rank array and combine the nodes under
		// the larger component
		parents[py] = px;
		return true;
	}

}
