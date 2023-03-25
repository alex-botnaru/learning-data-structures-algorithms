package com.abotnaru.problems.neetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

	/**
	 * Return a list of unique combinations in the input array that sum up to the
	 * target number.
	 * 
	 * @param candidates
	 * @param target
	 * @return
	 */
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		backtrackHelper(candidates, result, list, target, 0);
		return result;
	}

	private void backtrackHelper(int[] candidates, List<List<Integer>> result, List<Integer> list, int target,
			int start) {

		if (target == 0) {
			// target = 0 means elements in the list sum up to the original target. Add a
			// copy of the list in the result list.
			result.add(new ArrayList<>(list));
		} else if (target > 0) {
			for (int i = start; i < candidates.length; i++) {
				// Skip duplicate elements
				if (i > start && candidates[i] == candidates[i - 1]) {
					continue;
				}

				// Add, recursive call, and then remove the current element from the list.
				list.add(candidates[i]);
				backtrackHelper(candidates, result, list, target - candidates[i], i + 1);
				list.remove(list.size() - 1);
			}
		}

	}
}
