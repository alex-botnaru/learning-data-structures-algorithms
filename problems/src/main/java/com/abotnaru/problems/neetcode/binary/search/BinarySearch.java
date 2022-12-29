package com.abotnaru.problems.neetcode.binary.search;

public class BinarySearch {

	/**
	 * Searches for the target value in the sorted nums array.
	 * <p>
	 * Performs the binary search, returns the index of the element in the nums
	 * array if exists, -1 otherwise.
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public int search(int[] nums, int target) {
		// return binarySearchRecursive(nums, target, 0, nums.length - 1);
		return binarySearchIterative(nums, target);
	}

	private int binarySearchRecursive(int[] nums, int target, int start, int end) {
		int result = -1;

		if (start <= end) {
			int middle = (start + end) / 2;
			if (nums[middle] == target) {
				result = middle;
			} else if (nums[middle] > target) {
				result = binarySearchRecursive(nums, target, start, middle - 1);
			} else {
				result = binarySearchRecursive(nums, target, middle + 1, end);
			}
		}
		return result;
	}

	private int binarySearchIterative(int nums[], int target) {
		int result = -1;
		int start = 0;
		int end = nums.length - 1;
		while (start <= end) {
			int middle = (start + end) / 2;
			if (nums[middle] == target) {
				result = middle;
				break;
			} else if (nums[middle] > target) {
				end = middle - 1;
			} else {
				start = middle + 1;
			}
		}
		return result;
	}

}
