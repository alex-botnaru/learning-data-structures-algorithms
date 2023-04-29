package com.abotnaru.problems.neetcode.dynamic.programming.d1;

public class HouseRobberII {

	/**
	 * Return the max amount of money you can rob without alerting police
	 * 
	 * @param nums
	 * @return
	 */
	public int rob(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}
		// Compute max value excluding last house (as last house is next to first.
		// Then compute the max value excluding first house, return the max between two
		// computed values.
		return Math.max(robHelper(nums, 0, nums.length - 2), robHelper(nums, 1, nums.length - 1));
	}

	/**
	 * Compute the max value to rob from specified range
	 * 
	 * @param nums
	 * @param start
	 * @param end
	 * @return
	 */
	private int robHelper(int[] nums, int start, int end) {
		int rob1 = 0; // Max value not including last house
		int rob2 = 0; // Max value including last house
		for (int i = start; i <= end; i++) {
			int temp = Math.max(rob1 + nums[i], rob2);
			rob1 = rob2;
			rob2 = temp;
		}
		return rob2;
	}
}
