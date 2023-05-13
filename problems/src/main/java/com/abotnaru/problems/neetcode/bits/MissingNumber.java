package com.abotnaru.problems.neetcode.bits;

public class MissingNumber {

	/**
	 * Returns the only number missing from the input array
	 * 
	 * @param nums
	 * @return
	 */
	public int missingNumber(int[] nums) {
		int result = nums.length; // Initialize result with the array length - the last number
		for (int i = 0; i < nums.length; i++) {
			// XOR index and number from the array, same numbers will cancel each out
			result ^= i ^ nums[i];
			// alternatively, you can sum up the difference between the index and the number
			// in the array, same number will cancel each out.
			// result += i - nums[i];
		}

		return result;
	}
}
