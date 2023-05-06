package com.abotnaru.problems.neetcode.dynamic.programming.d2;

import java.util.HashMap;
import java.util.Map;

public class BurstBalloons {

	/**
	 * Returns the maximum coins you can collect by bursting balloons
	 * 
	 * @param nums
	 * @return
	 */
	public int maxCoins(int[] nums) {
		// Create a new array, add one element at the start and one at the end
		// initialized with one, fill the original values in between
		int[] newNums = new int[nums.length + 2];
		newNums[0] = 1;
		newNums[newNums.length - 1] = 1;
		for (int i = 0; i < nums.length; i++) {
			newNums[i + 1] = nums[i];
		}
		return dfs(newNums, new HashMap<>(), 1, newNums.length - 2);
	}

	/**
	 * Helper DFS function, memoization
	 * 
	 * @param nums
	 * @param cache
	 * @param left
	 * @param right
	 * @return
	 */
	private int dfs(int[] nums, Map<String, Integer> cache, int left, int right) {
		// Base case
		if (left > right) {
			return 0;
		}

		String key = left + "-" + right;
		// Return cached value
		if (cache.containsKey(key)) {
			return cache.get(key);
		}
		cache.put(key, 0);
		for (int i = left; i < right + 1; i++) {
			// Compute when the element (balloon) is burst last
			int coins = nums[left - 1] * nums[i] * nums[right + 1];
			// recursive call to compute bursting the previous balloons
			coins += dfs(nums, cache, left, i - 1) + dfs(nums, cache, i + 1, right);
			// Update the cache
			cache.put(key, Math.max(cache.get(key), coins));
		}
		return cache.get(key);
	}
}
