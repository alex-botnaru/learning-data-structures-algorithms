package com.abotnaru.problems.neetcode.dynamic.programming.d1;

import java.util.Arrays;

public class ClimbingStairs {

	/**
	 * Returns the number of distinct ways to climb the stairs.<br>
	 * Optimal solution O(n) time and constant space complexity.
	 * 
	 * @param n
	 * @return
	 */
	public int climbStairs(int n) {

		int pos1 = 1; // the final step, only one way to get here
		int pos2 = 1; // second step from top, only one way to get here as well, taking two steps will
						// jump over the final step
		for (int i = 0; i < n - 1; i++) {
			// At next step down, sum up the number of ways at the next (+1 step), and the
			// number of ways at next next step (+2 steps).
			int temp = pos1 + pos2;
			// Shift the values
			pos1 = pos2;
			pos2 = temp;
		}
		return pos2;
	}

	/**
	 * Bottom-up approach using an array.
	 * 
	 * @param n
	 * @return
	 */
	public int climbStairsBottomUp(int n) {
		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i < dp.length; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n];
	}

	/**
	 * Top-down recursive approach with memoization.<br>
	 * 
	 * @param n
	 * @return
	 */
	public int climbStairsMemo(int n) {
		int[] memo = new int[n + 1];
		Arrays.fill(memo, -1);
		// Recursive call till down
		return climbStairs(n - 1, memo) + climbStairs(n - 2, memo);
	}

	private int climbStairs(int n, int[] memo) {
		// Base cases
		if (n < 0)
			return 0;
		if (n == 0 || n == 1) {
			memo[n] = 1;
			return memo[n];
		}

		// Check memory if computed already
		if (memo[n] != -1)
			return memo[n];
		// Recursive call to compute the value
		memo[n] = climbStairs(n - 1, memo) + climbStairs(n - 2, memo);
		return memo[n];
	}
}
