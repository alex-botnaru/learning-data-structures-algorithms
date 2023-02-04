package com.abotnaru.problems.neetcode.linked.list;

public class FindDuplicateNumber {

	/**
	 * For a given array with size n + 1 and values between [1, n], returns the
	 * duplicated number.<br>
	 * Guarantee one duplicated number.
	 * <p>
	 * NeetCode solution
	 * 
	 * @param nums
	 * @return
	 */
	public int findDuplicate(int[] nums) {
		int slow = 0;
		int fast = 0;

		// Need to recognize that array elements create a cycled linked list.
		// Use Floyd's algorithm to detect the beginning of the cycle.

		// 1. Use fast and slow pointer to detect the intersection
		do {
			slow = nums[slow];
			fast = nums[nums[fast]];
		} while (slow != fast);

		// 2. Use two slow pointers to detect the beginning of the loop.
		int slow2 = 0;
		while (slow2 != slow) {
			slow = nums[slow];
			slow2 = nums[slow2];
		}

		return slow;
	}

	/**
	 * For a given array with size n + 1 and values between [1, n], returns the
	 * duplicated number.<br>
	 * Guarantee one duplicated number.
	 * <p>
	 * My initial solution
	 * 
	 * @param nums
	 * @return
	 */
	public int findDuplicateInitial(int[] nums) {

		int actualSum = 0;
		int correctSum = 0;

		// 1. Compute the sum of all elements, as well as the sum of elements when no
		// repeating number exist.
		for (int i = 0; i < nums.length; i++) {
			actualSum += nums[i];
			correctSum += (i + 1);
		}
		// 2. Extract the last element
		correctSum -= nums.length;
		// 3. Do the difference between actual sum and the sum without duplicates.
		return actualSum - correctSum;
	}

}
