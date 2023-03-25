package com.abotnaru.problems.neetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

	/**
	 * For the given array of unique integers, return all possible subsets without
	 * duplicates.
	 * 
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		subsetsHelper(nums, result, list, 0);
		return result;
	}

	private void subsetsHelper(int[] nums, List<List<Integer>> result, List<Integer> list, int start) {
		if (start >= nums.length) {
			// Make a copy of the current list
			result.add(new ArrayList<>(list));
		} else {
			// add the current element to the list and do a recursive call
			list.add(nums[start]);
			subsetsHelper(nums, result, list, start + 1);

			// remove the current element and do the backtracking call
			list.remove(list.size() - 1);
			subsetsHelper(nums, result, list, start + 1);
		}
	}
}
