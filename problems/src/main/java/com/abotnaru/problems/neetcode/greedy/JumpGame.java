package com.abotnaru.problems.neetcode.greedy;

public class JumpGame {

	/**
	 * Returns true if you can reach the last index, false otherwise
	 * 
	 * @param nums
	 * @return
	 */
	public boolean canJump(int[] nums) {

		// Set the goal as index of the last element
		int goal = nums.length - 1;

		// looping backwards
		for (int i = goal; i > -1; i--) {
			// if index + steps at that index is greater or equal than the goal, it means we
			// can reach the goal, shift the goal to the left
			if (i + nums[i] >= goal) {
				goal = i;
			}
		}

		// We can reach the end only if the goal was shifted to the first index
		return goal == 0;
	}
}
