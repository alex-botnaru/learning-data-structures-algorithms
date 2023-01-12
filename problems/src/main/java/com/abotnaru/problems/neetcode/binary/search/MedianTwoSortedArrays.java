package com.abotnaru.problems.neetcode.binary.search;

public class MedianTwoSortedArrays {

	/**
	 * Returns the median of the two sorted arrays.
	 * <p>
	 * The solution for neetcode, time complexity O(log(N+M))
	 * 
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		double result = .0;
		int m = nums1.length;
		int n = nums2.length;

		if (m > n) {
			// Call the same method switch the order of the array, so the shorter one is
			// first.
			return findMedianSortedArrays(nums2, nums1);
		}

		int total = n + m;
		int half = (total + 1) / 2;

		// Do binary search only on the shortest array
		int left = 0;
		int right = m;

		while (left <= right) {
			int i = left + (right - left) / 2; // middle of the shortest array
			int j = half - i; // How many elements to take from the longest array to be in the middle of the
								// merged array

			// Compute the four points around possible median
			int num1Left = (i > 0) ? nums1[i - 1] : Integer.MIN_VALUE;
			int num1Right = (i < m) ? nums1[i] : Integer.MAX_VALUE;
			int num2Left = (j > 0) ? nums2[j - 1] : Integer.MIN_VALUE;
			int num2Right = (j < n) ? nums2[j] : Integer.MAX_VALUE;

			if (num1Left <= num2Right && num2Left <= num1Right) {
				// Partition is correct, we are in the middle
				if (total % 2 == 0) {
					// Merged array length is even
					result = (Math.max(num1Left, num2Left) + Math.min(num1Right, num2Right)) / 2.;
				} else {
					// Merged array length is odd
					result = Math.max(num1Left, num2Left);
				}
				break;
			}
			// Partition is wrong, update left or right positions
			else if (num1Left > num2Right) {
				right = i - 1;
			} else {
				left = i + 1;
			}
		}

		return result;
	}

	/**
	 * Returns the median of the two sorted arrays.
	 * <p>
	 * This is the initial solution with time and space complexity O(N + M)
	 * 
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public double findMedianSortedArraysInitial(int[] nums1, int[] nums2) {
		int[] array = new int[nums1.length + nums2.length];
		int i = 0;
		int j = 0;
		int index = 0;
		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] < nums2[j]) {
				array[index] = nums1[i];
				i++;
			} else {
				array[index] = nums2[j];
				j++;
			}
			index++;
		}

		for (; i < nums1.length; i++) {
			array[index] = nums1[i];
			index++;
		}

		for (; j < nums2.length; j++) {
			array[index] = nums2[j];
			index++;
		}

		int middle = array.length / 2;

		if (array.length % 2 == 0) {
			return (array[middle] + array[middle - 1]) / 2.0;
		} else {
			return array[middle];
		}
	}

}
