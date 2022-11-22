package com.abotnaru.problems.neetcode.two.pointers;

public class ContainerWithMostWater {

	/**
	 * Returns the max area possible that can be form with two lines from the array.
	 * 
	 * @param height - an integer array of length n. There are n vertical lines
	 *               drawn such that the two endpoints of the ith line are (i, 0)
	 *               and (i, height[i]).
	 * @return
	 */
	public int maxArea(int[] height) {
		int maxArea = 0;
		int left = 0;
		int right = height.length - 1;
		while (left < right) {
			int area = (right - left) * Math.min(height[left], height[right]);
			maxArea = Math.max(maxArea, area);

			if (height[left] > height[right]) {
				right--;
			} else {
				left++;
			}
		}
		return maxArea;
	}
}
