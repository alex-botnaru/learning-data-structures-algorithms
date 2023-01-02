package com.abotnaru.problems.neetcode.binary.search;

public class KokoEatingBananas {

	/**
	 * Return the minimum eating speed to eat bananas from all piles within
	 * specified hours.
	 * <p>
	 * hours >= number of piles.<br>
	 * Time complexity is O(log(max(P)) * P)
	 * 
	 * @param piles
	 * @param hours
	 * @return
	 */
	public int minEatingSpeed(int[] piles, int hours) {

		int maxPile = 0;
		for (int i = 0; i < piles.length; i++) {
			// Find the biggest pile
			maxPile = Math.max(maxPile, piles[i]);
		}

		// We know that when the hours = piles.lenght, the worst speed is the value of
		// the largest pile
		int minSpeed = maxPile;
		// Initialize the possible range of speeds
		int start = 1;
		int end = maxPile;

		while (start < end) {
			// Try the middle value of the range
			int middle = (start + end) / 2;
			int hoursSpent = 0;
			// Calculate the hours needed to eat all bananas at the current speed
			for (int i = 0; i < piles.length; i++) {
				hoursSpent += Math.ceil(piles[i] / (double) middle);
			}

			// Cut the search by half of the values.
			if (hoursSpent <= hours) {
				minSpeed = Math.min(minSpeed, middle);
				end = middle - 1;
			} else {
				start = middle + 1;
			}

		}

		return minSpeed;
	}

}
