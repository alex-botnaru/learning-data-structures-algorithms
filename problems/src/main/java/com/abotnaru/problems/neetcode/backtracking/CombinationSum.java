package com.abotnaru.problems.neetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

	/**
	 * Return a list of unique combinations of elements from candidates array that
	 * sum up to the target number.
	 * 
	 * @param candidates
	 * @param target
	 * @return
	 */
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		combinationHelper(candidates, target, result, list, 0);
		return result;
	}

	private void combinationHelper(int[] candidates, int target, List<List<Integer>> result, List<Integer> list,
			int index) {
		if (target == 0) {
			// target = 0 means all the elements in the array sum up to the original target
			result.add(new ArrayList<>(list));
		} else if (target < 0 || index >= candidates.length) {
			// Skip, do nothing
		} else {
			// Add current element to the list
			list.add(candidates[index]);
			// Check if adding the same element will achieve the target sum
			combinationHelper(candidates, target - candidates[index], result, list, index);

			// Remove the current candidate
			list.remove(list.size() - 1);
			// Check if adding next element will add up to the target sum
			combinationHelper(candidates, target, result, list, index + 1);
		}
	}
}
