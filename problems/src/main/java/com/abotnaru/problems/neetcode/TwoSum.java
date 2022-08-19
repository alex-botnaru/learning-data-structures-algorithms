package com.abotnaru.problems.neetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Constraints:<br>
 * - Only one valid answer exists.
 */
public class TwoSum {

	/**
	 * Returns indices of the two numbers such that they add up to target.
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] twoSum(int[] nums, int target) {
		int[] result = new int[] { -1, -1 };

		/**
		 * Iterate through each element<br>
		 * - calculate the difference between the target and the current element<br>
		 * - is the difference in the map? then return the index from the map and
		 * current index.<br>
		 * - if the difference doesn't exist, insert the value as the key and index as
		 * value.
		 * <p>
		 * This takes O(N) time and space complexity<br>
		 */
		Map<Integer, Integer> previousElementsMap = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int previousValue = target - nums[i];
			if (previousElementsMap.containsKey(previousValue)) {
				result[0] = previousElementsMap.get(previousValue);
				result[1] = i;
				break;
			} else {
				previousElementsMap.put(nums[i], i);
			}
		}

		return result;
	}
}
