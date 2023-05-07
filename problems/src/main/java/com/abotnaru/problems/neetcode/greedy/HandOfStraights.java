package com.abotnaru.problems.neetcode.greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HandOfStraights {

	/**
	 * Returns true if cards in arrays can be arranged in groups of groupSize, and
	 * order of the cards are consecutive. False otherwise.
	 * 
	 * @param hand
	 * @param groupSize
	 * @return
	 */
	public boolean isNStraightHand(int[] hand, int groupSize) {

		// See if cards can be grouped in groups of groupSize
		if (hand.length % groupSize != 0) {
			return false;
		}

		Map<Integer, Integer> occMap = new HashMap<>();

		// Count card occurrences
		for (int card : hand) {
			occMap.put(card, occMap.getOrDefault(card, 0) + 1);
		}

		// Sort the array.
		Arrays.sort(hand);

		for (int card : hand) {
			if (occMap.get(card) <= 0) {
				// Skip if no cards
				continue;
			}

			// Loop to form a group
			for (int i = 1; i < groupSize; i++) {
				int count = occMap.getOrDefault(card + i, 0);
				// If next card in group exists, decrement its occurrence
				if (count > 0) {
					occMap.put(card + i, count - 1);
				} else {
					// If doesn't exist, return false immediately
					return false;
				}
			}
			// Decrement the occurrence of the start card
			occMap.put(card, occMap.get(card) - 1);

		}

		return true;
	}
}
