package com.abotnaru.problems.neetcode.arrays.hashing;

public class ProductOfArrayExceptSelf {

	/**
	 * Return an array such that any element in the array is equal to the product of
	 * all the elements in the input array except that element.
	 * <p>
	 * Time complexity is O(N). Space complexity is O(1) if not considering the
	 * output array as an extra space.
	 * 
	 * @param nums
	 * @return
	 */
	public int[] productExceptSelf(int[] nums) {

		int[] result = new int[nums.length];

		// Loop from start to end. At the current index store the previous product
		// (default value 1)
		int prefix = 1;
		for (int i = 0; i < result.length; i++) {
			result[i] = prefix;
			prefix *= nums[i];
		}

		// Loop from end to beginning. Multiply the current element with the next
		// product value (computed from the end, default value 1)
		int postfix = 1;
		for (int i = result.length - 1; i >= 0; i--) {
			result[i] *= postfix;
			postfix *= nums[i];
		}

		return result;
	}
}
