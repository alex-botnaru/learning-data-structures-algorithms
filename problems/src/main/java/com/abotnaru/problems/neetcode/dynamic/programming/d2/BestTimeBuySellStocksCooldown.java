package com.abotnaru.problems.neetcode.dynamic.programming.d2;

import java.util.HashMap;
import java.util.Map;

public class BestTimeBuySellStocksCooldown {

	/**
	 * Returns the max profit that can be achieved.
	 * 
	 * @param prices
	 * @return
	 */
	public int maxProfit(int[] prices) {
		// Initialize a cache to store possible profit
		Map<String, Integer> cache = new HashMap<>();
		return dfsHelper(prices, cache, 0, true);
	}

	/**
	 * DFS helper function
	 * 
	 * @param prices
	 * @param cache
	 * @param day
	 * @param buying
	 * @return
	 */
	private int dfsHelper(int[] prices, Map<String, Integer> cache, int day, boolean buying) {
		if (day >= prices.length) {
			// base case - index out of bounds
			return 0;
		}

		String key = day + "-" + buying;

		if (cache.containsKey(key)) {
			// base case - solution already cached
			return cache.get(key);
		}

		// If we choose cooldown, move one day with the same buying status
		int cooldown = dfsHelper(prices, cache, day + 1, buying);
		int profit;
		if (buying) {
			// Spend on buying, the only option is to sell next day
			profit = dfsHelper(prices, cache, day + 1, !buying) - prices[day];
		} else {
			// Selling, compute profit, but we can buy only the day after
			profit = dfsHelper(prices, cache, day + 2, !buying) + prices[day];
		}

		// Compute max between cooldown and profit and cache it
		cache.put(key, Math.max(cooldown, profit));
		return cache.get(key);
	}
}
