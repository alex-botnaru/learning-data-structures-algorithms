package com.abotnaru.problems.neetcode.dynamic.programming.d1;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

	/**
	 * Returns the length of the longest strictly increasing subsequence.
	 * 
	 * @param nums
	 * @return
	 */
	public int lengthOfLIS(int[] nums) {
		int[] cache = new int[nums.length];
		Arrays.fill(cache, 1);
		int max = 1;

		// Loop backwards and cache the result
		for (int i = nums.length - 1; i > -1; i--) {
			// Loop through the cached solution
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] < nums[j]) {
					// If consider including the element at j in the sequence, compute new max
					cache[i] = Math.max(cache[i], 1 + cache[j]);
				}
			}
			// Update the max
			max = Math.max(max, cache[i]);
		}

		return max;
	}
}
