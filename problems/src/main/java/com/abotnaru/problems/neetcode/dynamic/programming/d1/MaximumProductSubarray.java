package com.abotnaru.problems.neetcode.dynamic.programming.d1;

public class MaximumProductSubarray {

	/**
	 * Returns the max product number of a subarray of provided array
	 * 
	 * @param nums
	 * @return
	 */
	public int maxProduct(int[] nums) {
		int result = nums[0];
		int max = 1; // Stores the maximum product value
		int min = 1; // Stores the minimum product value

		for (int num : nums) {

			int tmpMax = max * num; // compute new max value separately, as we alter the max value in the next line
			// Compute max and min from the same 3 values: current number, product of min
			// and current number, product of max and current number
			max = Math.max(num, Math.max(min * num, tmpMax));
			min = Math.min(num, Math.min(min * num, tmpMax));
			result = Math.max(result, max); // Update the max value
		}

		return result;
	}
}
