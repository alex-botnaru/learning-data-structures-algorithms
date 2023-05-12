package com.abotnaru.problems.neetcode.bits;

public class SingleNumber {

	/**
	 * Find and return the single one element, all other elements are repeated twice
	 * 
	 * @param nums
	 * @return
	 */
	public int singleNumber(int[] nums) {

		int res = nums[0];
		for (int i = 1; i < nums.length; i++) {
			// Do XOR operation as the two numbers will cancel each one out
			res ^= nums[i];
		}
		return res;
	}
}
