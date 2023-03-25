package com.abotnaru.problems.neetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {

	/**
	 * Returns all possible subsets of the array elements. No duplicated subsets.
	 * 
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		backtrackHelper(nums, result, list, 0);

		return result;
	}

	private void backtrackHelper(int[] nums, List<List<Integer>> result, List<Integer> list, int index) {

		// Add current subset
		result.add(new ArrayList<>(list));

		for (int i = index; i < nums.length; i++) {
			// Iterate through the rest of elements, but skip duplicates
			if (i > index && nums[i] == nums[i - 1]) {
				continue;
			}

			// Add element to the list, recursive call to the next index, and then remove
			// the element
			list.add(nums[i]);
			backtrackHelper(nums, result, list, i + 1);
			list.remove(list.size() - 1);
		}

	}

}
