package com.abotnaru.problems.neetcode.greedy;

public class MergeTriplets {

	/**
	 * Returns true if from the list of triplets we can create the target template,
	 * false otherwise.
	 * 
	 * @param triplets
	 * @param target
	 * @return
	 */
	public boolean mergeTriplets(int[][] triplets, int[] target) {

		// Array to check if we can create the target triplet
		boolean[] match = new boolean[target.length];

		for (int[] triplet : triplets) {
			// Skip if one of the values in the triplet is greater than in the target
			if (triplet[0] > target[0] || triplet[1] > target[1] || triplet[2] > target[2]) {
				continue;
			}

			// Mark the index where the value is matching target
			for (int i = 0; i < target.length; i++) {
				match[i] |= triplet[i] == target[i];
			}
		}

		// Return true if we found all matches
		return match[0] && match[1] && match[2];
	}
}
