package com.abotnaru.problems.neetcode.advanced.graphs;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class MinCostConnectPoints {

	/**
	 * Returns the minimum cost to make all the edge connected.
	 * 
	 * @param points
	 * @return
	 */
	public int minCostConnectPoints(int[][] points) {
		PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
		Set<Integer> visited = new HashSet<>();
		int cost = 0;

		minHeap.offer(new int[] { 0, 0 }); // Adding a dummy node with distance 0 as a starting point

		// When the size of the visited set is equal to the number of points, then all
		// nodes are connected
		while (visited.size() < points.length) {
			// Minimum Spanning Tree - Prim's Algorithm
			int distance = minHeap.peek()[0];
			int node = minHeap.poll()[1];

			if (visited.contains(node)) {
				// Skip if node was visited
				continue;
			}
			// Add the node and increment the distance cost
			visited.add(node);
			cost += distance;

			for (int i = 0; i < points.length; i++) {
				// For every unvisited node, add the remaining nodes and the distance from the
				// current node to the Min Heap
				if (!visited.contains(i)) {
					minHeap.offer(new int[] { distance(points[i], points[node]), i });
				}
			}

		}

		return cost;
	}

	/**
	 * Helper method to calculate manhattan distance between two points
	 * 
	 * @param point1
	 * @param point2
	 * @return
	 */
	private int distance(int[] point1, int[] point2) {
		return Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1]);
	}
}
