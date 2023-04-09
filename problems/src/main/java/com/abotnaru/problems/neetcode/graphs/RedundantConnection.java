package com.abotnaru.problems.neetcode.graphs;

public class RedundantConnection {

	/**
	 * Return an edge that can be removed so that the resulting graph is a tree of n
	 * nodes.
	 * 
	 * @param edges
	 * @return
	 */
	public int[] findRedundantConnection(int[][] edges) {

		// initialize an array where the index represents the node, and the value
		// represents the parent.
		// If the value and index are equal, it means the node is a top parent
		// 0 index is ignored
		int[] parents = new int[edges.length + 1];

		// Initialize the array, initially all nodes point at themselves
		for (int i = 0; i < parents.length; i++) {
			parents[i] = i;
		}

		for (int[] edge : edges) {
			// If the nodes of the edge have common parent, then it is redundant, return it
			if (find(parents, edge[0]) == find(parents, edge[1])) {
				return edge;
			}
			// else connect the nodes
			union(parents, edge[0], edge[1]);
		}
		return new int[0];
	}

	/**
	 * Helper method to return the top parent of a node
	 * 
	 * @param parents
	 * @param x
	 * @return
	 */
	private int find(int[] parents, int x) {
		if (x == parents[x]) {
			return x;
		}
		return find(parents, parents[x]);
	}

	/**
	 * helper method, to sets the top parent of node y to top parent of node x
	 * 
	 * @param parents
	 * @param x
	 * @param y
	 */
	private void union(int[] parents, int x, int y) {
		parents[find(parents, y)] = find(parents, x);
	}
}
