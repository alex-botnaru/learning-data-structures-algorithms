package com.abotnaru.problems.neetcode.binary.search;

public class SearchRotatedSortedArray {

	public int search(int[] input, int target) {
		int start = 0;
		int end = input.length - 1;
		while (start <= end) {

			int middle = (start + end) / 2;
			if (input[middle] == target) {
				return middle;
			} else if (start == end) {
				// Exit loop condition
				break;
			} else if (input[start] <= input[middle] && target < input[start]) {
				// Case when left sub-array doesn't contain the target.
				// a) left part is valid sorted sub-array
				// b) all the values in the left part are greater than target
				start = middle + 1;
			} else {
				// Case when all elements are in the left sub-array, exclude the right part
				end = middle;
			}
		}
		return -1;
	}

}
