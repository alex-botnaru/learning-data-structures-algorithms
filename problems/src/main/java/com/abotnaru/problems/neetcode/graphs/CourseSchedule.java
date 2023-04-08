package com.abotnaru.problems.neetcode.graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CourseSchedule {

	/**
	 * Return true if all courses can be finish and there is no cycle. False
	 * otherwise.
	 * 
	 * @param numCourses
	 * @param prerequisites
	 * @return
	 */
	public boolean canFinish(int numCourses, int[][] prerequisites) {

		Map<Integer, Set<Integer>> graph = new HashMap<>();
		Set<Integer> visited = new HashSet<>();
		// First create the adjacency list
		for (int i = 0; i < numCourses; i++) {
			graph.put(i, new HashSet<>());
		}
		for (int[] edge : prerequisites) {
			graph.get(edge[0]).add(edge[1]);
		}

		// Loop through all the courses.
		for (int i = 0; i < numCourses; i++) {
			if (!canComplete(i, graph, visited)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Helper DFS method to detect cycles
	 * 
	 * @param course
	 * @param graph
	 * @param visited
	 * @return
	 */
	private boolean canComplete(int course, Map<Integer, Set<Integer>> graph, Set<Integer> visited) {
		if (visited.contains(course)) {
			// Cycle detected, return false
			return false;
		}
		if (graph.get(course).isEmpty()) {
			// No prerequisites, return true
			return true;
		}

		visited.add(course);
		for (int prerequistie : graph.get(course)) {
			// If a cycle detected in any prerequisites, break the loop and return false
			if (!canComplete(prerequistie, graph, visited)) {
				return false;
			}
		}
		visited.remove(course);
		// Clear the set for the node, since it can be completed.
		graph.get(course).clear();
		return true;
	}
}
