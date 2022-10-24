package com.abotnaru.problems.neetcode.sliding.window;

public class BestTimeBuySellStock {

	/**
	 * Returns the max profit you can get from an array of stock prices.
	 * 
	 * @param prices
	 * @return
	 */
	public int maxProfit(int[] prices) {
		int maxProfit = 0;
		// 2. Optimized, O(N) time complexity
		int buy = 0;
		int sell = 1;
		while (sell < prices.length) {
			maxProfit = Math.max(maxProfit, prices[sell] - prices[buy]);
			if (prices[buy] > prices[sell]) {
				buy = sell;
			}
			sell++;

		}

		return maxProfit;
	}

}
