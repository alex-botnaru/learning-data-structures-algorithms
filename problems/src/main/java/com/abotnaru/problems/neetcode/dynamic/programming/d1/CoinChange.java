package com.abotnaru.problems.neetcode.dynamic.programming.d1;

import java.util.Arrays;

public class CoinChange {

	/**
	 * Returns the fewest number of coins that needed to make up the amount.
	 * 
	 * @param coins
	 * @param amount
	 * @return
	 */
	public int coinChange(int[] coins, int amount) {
		if (amount < 0 || coins == null || coins.length == 0) {
			return 0;
		}
		// Initialize dynamic programming array with max values.
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, amount + 1);
		dp[0] = 0; // to obtain amount 0 we need 0 coins

		for (int i = 1; i <= amount; i++) {
			// Looping through all possible sums amount
			for (int coin : coins) {
				// Iterating through each coin
				if (i - coin >= 0) {
					// Update dp only if the coin used doesn't go over target amount
					dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
				}
			}
		}

		if (dp[amount] == amount + 1) {
			// Max value, means the value wasn't updated, so it's impossible to add up to
			// amount
			return -1;
		}
		return dp[amount];
	}
}
