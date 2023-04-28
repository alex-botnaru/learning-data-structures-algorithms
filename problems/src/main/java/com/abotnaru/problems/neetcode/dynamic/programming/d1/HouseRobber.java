package com.abotnaru.problems.neetcode.dynamic.programming.d1;

public class HouseRobber {

	/**
	 * Returns the max amount of money you can rob without alerting the police.
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

		int robNotIncludingLastHouse = 0; // Store the max value not including the last house
		int robIncludingLastHouse = 0; // Store the max value including the last house
		for (int num : nums) {
			// When using the max value without including the last house, we must include
			// the current house.
			// Including the last house, we should skip the current house.
			int temp = Math.max(robNotIncludingLastHouse + num, robIncludingLastHouse);
			// Shift the values by one house
			robNotIncludingLastHouse = robIncludingLastHouse;
			robIncludingLastHouse = temp;
		}
		return robIncludingLastHouse;
	}
}
