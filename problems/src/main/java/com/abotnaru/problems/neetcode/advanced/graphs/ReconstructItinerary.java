package com.abotnaru.problems.neetcode.advanced.graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

public class ReconstructItinerary {

	/**
	 * Reconstruct the itinerary from a list of tickets
	 * 
	 * @param tickets
	 * @return
	 */
	public List<String> findItinerary(List<List<String>> tickets) {
		// Use adjacency list graph, use Min Heap to sort the nodes in lexicographical
		// order
		Map<String, PriorityQueue<String>> graph = new HashMap<>();
		LinkedList<String> itinerary = new LinkedList<>();

		for (List<String> ticket : tickets) {
			// add the nodes and edges to the graph
			graph.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).add(ticket.get(1));
		}

		Stack<String> stack = new Stack<>();
		stack.push("JFK"); // Starting point always is JFK

		while (!stack.empty()) {
			// peek the destination from the top of the stack, current node
			String nextDestination = stack.peek();
			if (graph.containsKey(nextDestination) && !graph.get(nextDestination).isEmpty()) {
				// If it has more destinations to travel, add the to the stack
				stack.push(graph.get(nextDestination).poll());
			} else {
				// Otherwise, remove from the stack and add it to the itinerary list
				itinerary.addFirst(stack.pop());
			}
		}

		return itinerary;
	}
}
