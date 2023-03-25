package com.abotnaru.problems.neetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

	/**
	 * For the given input array, return all the possible permutations of its
	 * elements.
	 * 
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		backtrackSwapper(nums, result, 0);
		return result;
	}

	private void backtrackSwapper(int[] nums, List<List<Integer>> result, int start) {

		// One possible permutation is created, add it to the list
		if (start >= nums.length) {
			List<Integer> list = new ArrayList<>();
			for (int num : nums) {
				list.add(num);
			}
			result.add(list);
			return;
		}

		for (int i = start; i < nums.length; i++) {
			// Swap the elements
			swap(nums, start, i);
			// Do a recursive call
			backtrackSwapper(nums, result, start + 1);
			// Swap the elements back
			swap(nums, start, i);
		}
	}

	private void swap(int[] nums, int index1, int index2) {
		int temp = nums[index1];
		nums[index1] = nums[index2];
		nums[index2] = temp;
	}
}
