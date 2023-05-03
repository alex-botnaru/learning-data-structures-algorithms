package com.abotnaru.problems.neetcode.dynamic.programming.d2;

import java.util.HashMap;
import java.util.Map;

public class CoinChangeII {

	/**
	 * Returns the number of unique coins combination that make up the amount. If
	 * impossible, returns 0.
	 * <p>
	 * O(coins x amount) time and O(amount) space complexity
	 * 
	 * @param amount
	 * @param coins
	 * @return
	 */
	public int change(int amount, int[] coins) {

		// Cache represents last row in the matrix
		int[] cache = new int[amount + 1];
		cache[0] = 1; // There is only one way to come up with 0 amount for any coin denomination

		for (int coin : coins) { // Rows are the coins
			for (int i = 1; i <= amount; i++) { // columns are the amounts
				if (coin <= i) {
					// if coin denomination is smaller or equal to the amount
					// current cache value is the sum of current value plus the cached value at
					// amount - coin denomination
					cache[i] += cache[i - coin];
				}
			}
		}

		return cache[amount];
	}

	/**
	 * Recursive solution, O(coins x amount) time and space complexity
	 * 
	 * @param amount
	 * @param coins
	 * @return
	 */
	public int changeWithDfs(int amount, int[] coins) {
		return dfsHelper(amount, coins, new HashMap<>(), 0, 0);
	}

	private int dfsHelper(int amount, int[] coins, Map<String, Integer> cache, int index, int ways) {
		if (ways == amount) {
			return 1;
		}

		if (ways > amount || index >= coins.length) {
			return 0;
		}

		String key = index + "-" + ways;
		if (cache.containsKey(key)) {
			return cache.get(key);
		}

		cache.put(key, dfsHelper(amount, coins, cache, index, ways + coins[index])
				+ dfsHelper(amount, coins, cache, index + 1, ways));
		return cache.get(key);
	}
}
