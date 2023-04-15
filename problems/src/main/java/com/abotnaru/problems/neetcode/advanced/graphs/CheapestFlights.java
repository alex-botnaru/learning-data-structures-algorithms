package com.abotnaru.problems.neetcode.advanced.graphs;

import java.util.Arrays;

public class CheapestFlights {

	/**
	 * Returns the cheapest flight from src to dst with at most k stops.
	 * 
	 * @param n
	 * @param flights
	 * @param src
	 * @param dst
	 * @param k
	 * @return
	 */
	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

		// Using Bellman-Ford algorithm
		// Initialize an array with n elements, where index represents the node and the
		// value the min price to get to that node. Initialize all the values with
		// infinite value. For the source node, initialize the value with 0, since it
		// doesn't cost anything to get there.
		int[] prices = new int[n];
		Arrays.fill(prices, Integer.MAX_VALUE);
		prices[src] = 0;

		// Loop K times
		for (int i = 0; i < k + 1; i++) {
			// Create a temporary array, don't update the original one
			int[] tempPrices = Arrays.copyOf(prices, n);

			for (int[] flight : flights) {
				int source = flight[0];
				int destination = flight[1];
				int price = flight[2];

				// Skip if the source has not been visited
				if (prices[source] == Integer.MAX_VALUE) {
					continue;
				}

				// Update the price in the temporary table if the current price is smaller than
				// in original table
				if (prices[source] + price < tempPrices[destination]) {
					tempPrices[destination] = prices[source] + price;
				}
			}

			prices = tempPrices;
		}

		// return -1 if destination node has not been visited, or the value
		return prices[dst] < Integer.MAX_VALUE ? prices[dst] : -1;
	}
}
