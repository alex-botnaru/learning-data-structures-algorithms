package com.abotnaru.problems.neetcode.binary.search;

public class MinimumRotatedSortedArray {

	/**
	 * Return the minimum value in the rotated sorted array.
	 * 
	 * @param input
	 * @return
	 */
	public int findMin(int[] input) {
		int start = 0;
		int end = input.length - 1;
		int minValue = input[start];

		while (start <= end) {
			int middle = (start + end) / 2;
			minValue = Math.min(minValue, input[middle]);
			if (input[middle] < input[end]) {
				// The right portion of the array is sorted so skip it. Search the left portion.
				end = middle;
			} else {
				// Otherwise the left portion is sorted, search in the right portion.
				start = middle + 1;
			}
		}
		return minValue;
	}

}
