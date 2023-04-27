package com.abotnaru.problems.neetcode.dynamic.programming.d1;

public class MinCostClimbingStairs {

	/**
	 * Returns the minimum costs to reach the top step
	 * 
	 * @param cost
	 * @return
	 */
	public int minCostClimbingStairs(int[] cost) {
		// Initialize a dynamic programming array with one more element which represents
		// the top (final destination)
		int[] result = new int[cost.length + 1];
		result[cost.length] = 0; // cost to start from top is 0
		result[cost.length - 1] = cost[cost.length - 1]; // cost from last step to reach the top

		// Iterating from top steps to bottom, calculate the minimum cost to reach the
		// top
		for (int i = cost.length - 2; i > -1; i--) {
			// Current minimum cost, is the current step cost plus minimum between next two
			// steps
			result[i] = Math.min(result[i + 1], result[i + 2]) + cost[i];
		}

		// Return the minimum between the first two steps, as we only can start from
		// step 0 or 1
		return Math.min(result[0], result[1]);
	}
}
