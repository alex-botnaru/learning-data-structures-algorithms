package com.abotnaru.problems.neetcode.advanced.graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class NetworkDelayTime {

	/**
	 * Returns the minimum time necessary to reach all nodes from node k, returns -1
	 * if it is not possible. This implementation uses Dijkstra's algorithm.
	 * 
	 * @param times
	 * @param n
	 * @param k
	 * @return
	 */
	public int networkDelayTime(int[][] times, int n, int k) {
		Map<Integer, Set<int[]>> graph = new HashMap<>();
		PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
		Set<Integer> visited = new HashSet<>();
		int minTime = 0;

		// Create the graph, for each node set an empty set
		for (int i = 1; i <= n; i++) {
			graph.put(i, new HashSet<>());
		}

		// Add the edges to the graph
		for (int[] edge : times) {
			graph.get(edge[0]).add(new int[] { edge[1], edge[2] });
		}

		// Add the starting node with the weight 0
		minHeap.add(new int[] { 0, k });

		while (!minHeap.isEmpty()) {
			// remove the top element from the queue, get node and current time
			int time = minHeap.peek()[0];
			int node = minHeap.poll()[1];

			// Skip if node was visited
			if (visited.contains(node)) {
				continue;
			}

			// Mark node as visited and update the time
			visited.add(node);
			minTime = Math.max(minTime, time);

			for (int[] edge : graph.get(node)) {
				// Loop through each neighbor node that has not been visited
				if (!visited.contains(edge[0])) {
					// Add to the heap, update the time
					minHeap.add(new int[] { time + edge[1], edge[0] });
				}
			}

		}

		// Return min time only if all nodes have been visited
		return visited.size() == n ? minTime : -1;
	}
}
