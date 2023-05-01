package com.abotnaru.problems.neetcode.dynamic.programming.d1;

import java.util.HashSet;
import java.util.Set;

public class PartitionEqualSubsetSum {

	/**
	 * Returns true if the elements of the provided array can be partitioned into
	 * two subsets with equal sum.
	 * 
	 * @param nums
	 * @return
	 */
	public boolean canPartition(int[] nums) {
		int sum = 0;
		// Calculate total sum
		for (int num : nums) {
			sum += num;
		}

		// If sum is odd, cannot partition, return false right away
		if (sum % 2 != 0) {
			return false;
		}
		// Compute target sum
		int target = sum / 2;

		// Initialize a set to store all possible sums
		Set<Integer> dp = new HashSet<>();
		dp.add(0);

		for (int num : nums) {
			// Iterate through each value in the array, and then through each sum in the
			// set, compute new sums and add them to the set.
			Set<Integer> nextDp = new HashSet<>(dp);
			for (int s : dp) {
				if (s + num == target) {
					// If a target is found, return true immediately
					return true;
				}
				nextDp.add(s + num);
			}
			dp = nextDp;
		}

		return false;
	}
}
