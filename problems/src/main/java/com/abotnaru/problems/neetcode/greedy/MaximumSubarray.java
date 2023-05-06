package com.abotnaru.problems.neetcode.greedy;

public class MaximumSubarray {

	/**
	 * Returns the largest sum of an sub-array, the sub-array must be contiguous
	 * 
	 * @param nums
	 * @return
	 */
	public int maxSubArray(int[] nums) {
		int maxSubarray = nums[0];
		int currentSum = 0;

		for (int num : nums) {

			currentSum += num;

			maxSubarray = Math.max(maxSubarray, currentSum);
			if (currentSum < 0) {
				// If current sum is smaller than 0, reset it
				currentSum = 0;
			}
		}
		return maxSubarray;
	}
}
