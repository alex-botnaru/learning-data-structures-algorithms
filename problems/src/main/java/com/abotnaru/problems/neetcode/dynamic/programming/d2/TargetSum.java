package com.abotnaru.problems.neetcode.dynamic.programming.d2;

import java.util.HashMap;
import java.util.Map;

public class TargetSum {

	/**
	 * Returns the total number of expressions you can build by alternating
	 * operation sign that add up to target sum.
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public int findTargetSumWays(int[] nums, int target) {

		return dfsHelper(nums, target, new HashMap<>(), 0, 0);
	}

	/**
	 * DFS helper function with caching
	 * 
	 * @param nums
	 * @param target
	 * @param cache
	 * @param index
	 * @param total
	 * @return
	 */
	private int dfsHelper(int[] nums, int target, Map<String, Integer> cache, int index, int total) {
		if (index == nums.length) {
			return total == target ? 1 : 0;
		}

		String key = index + "-" + total;
		if (cache.containsKey(key)) {
			return cache.get(key);
		}

		cache.put(key, dfsHelper(nums, target, cache, index + 1, total + nums[index])
				+ dfsHelper(nums, target, cache, index + 1, total - nums[index]));

		return cache.get(key);
	}
}
