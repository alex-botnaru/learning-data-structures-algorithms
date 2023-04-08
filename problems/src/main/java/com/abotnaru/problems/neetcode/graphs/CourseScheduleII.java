package com.abotnaru.problems.neetcode.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CourseScheduleII {

	/**
	 * Return the order of coursed to be taken to finish all of them. If it is
	 * impossible to finish all the courses, return an empty array.
	 * 
	 * @param numCourses
	 * @param prerequisites
	 * @return
	 */
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		Map<Integer, Set<Integer>> graph = new HashMap<>();
		List<Integer> output = new ArrayList<>();
		int[] result = new int[0];
		// First create the adjacency list
		for (int i = 0; i < numCourses; i++) {
			graph.put(i, new HashSet<>());
		}
		for (int[] edge : prerequisites) {
			graph.get(edge[0]).add(edge[1]);
		}

		// Keep track of nodes already visited and no need to visit again
		Set<Integer> visited = new HashSet<>();
		// Set to detect cycles, stores the currently visiting nodes
		Set<Integer> visiting = new HashSet<>();
		for (int i = 0; i < numCourses; i++) {
			dfsHelper(graph, visited, visiting, output, i);
		}

		// Build the output array
		if (output.size() == numCourses) {
			result = new int[numCourses];
			for (int i = 0; i < numCourses; i++) {
				result[i] = output.get(i);
			}
			return result;
		}
		return result;
	}

	/**
	 * Helper DFS method
	 * 
	 * @param graph
	 * @param visited
	 * @param visiting
	 * @param output
	 * @param node
	 * @return
	 */
	private boolean dfsHelper(Map<Integer, Set<Integer>> graph, Set<Integer> visited, Set<Integer> visiting,
			List<Integer> output, int node) {

		if (visiting.contains(node)) {
			// Cycle detected
			return false;
		}

		if (visited.contains(node)) {
			// Already visited, no need to visit again
			return true;
		}

		visiting.add(node);
		for (int prerequisite : graph.get(node)) {
			// check the prerequisites, if cycle detected, return false immediately
			if (!dfsHelper(graph, visited, visiting, output, prerequisite)) {
				return false;
			}
		}
		visiting.remove(node);
		// Mark as visited and add to the output
		visited.add(node);
		output.add(node);
		return true;
	}
}
