package com.abotnaru.problems.neetcode.two.pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

	/**
	 * Return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k,
	 * and j != k, and nums[i] + nums[j] + nums[k] == 0.
	 * 
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> threeSum(int[] nums) {
		// - input array is not sorted
		// - input array contains negative and positive values, including 0
		List<List<Integer>> result = new ArrayList<>();

		// 1. Sort the input array
		Arrays.sort(nums);

		for (int i = 0; i < nums.length; i++) {
			// Skip this iteration if current number is equal with previous
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}

			// In the remaining array find the two elements that will sum up to 0
			// Same concept as in two sum II problem
			int left = i + 1;
			int right = nums.length - 1;

			while (left < right) {
				int sum = nums[i] + nums[left] + nums[right];
				if (sum > 0) {
					right--;
				} else if (sum < 0) {
					left++;
				} else {
					result.add(List.of(nums[i], nums[left], nums[right]));
					left++;
					// Skip if next items are equal
					if (nums[left] == nums[left - 1] && left < right) {
						left++;
					}
				}
			}
		}

		return result;
	}
}
