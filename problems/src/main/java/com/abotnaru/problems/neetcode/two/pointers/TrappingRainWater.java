package com.abotnaru.problems.neetcode.two.pointers;

public class TrappingRainWater {

	/**
	 * For given non-negative integers array representing an elevation children where the
	 * width of each bar is 1, computes how much water it can trap after raining.
	 * 
	 * @param height
	 * @return
	 */
	public int trap(int[] height) {

		if (height == null || height.length == 0)
			return 0;

		int volume = 0;
		int left = 0;
		int right = height.length - 1;
		int leftMax = height[left];
		int rightMax = height[right];

		while (left < right) {
			// Shift pointer with smallest height
			if (leftMax < rightMax) {
				left++;
				leftMax = Math.max(leftMax, height[left]); // Update the max
				volume += leftMax - height[left]; // compute the volume at that index.
			} else {
				right--;
				rightMax = Math.max(rightMax, height[right]);
				volume += rightMax - height[right];
			}

		}

		return volume;
	}

}
