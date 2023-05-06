package com.abotnaru.problems.neetcode.greedy;

public class JumpGameII {

	/**
	 * Returns the minimum number of jumps to reach the last index from first one.
	 * 
	 * @param nums
	 * @return
	 */
	public int jump(int[] nums) {
		int jumps = 0;
		// Left and right pointers point at the initial position, index 0.
		int left = 0;
		int right = 0;

		// While in array bounds
		while (right < nums.length - 1) {
			int farthest = 0;
			// Find the farthest index we can jump from current sub-array
			for (int i = left; i < right + 1; i++) {
				farthest = Math.max(farthest, i + nums[i]);
			}
			// increment jumps and update window boundaries
			jumps++;
			left = right + 1;
			right = farthest;
		}

		return jumps;
	}
}
