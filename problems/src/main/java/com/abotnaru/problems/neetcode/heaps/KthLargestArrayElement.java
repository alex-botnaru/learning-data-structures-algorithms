package com.abotnaru.problems.neetcode.heaps;

import java.util.PriorityQueue;

public class KthLargestArrayElement {

	/**
	 * Returns the Kth largest element in the array
	 * 
	 * @param nums
	 * @param k
	 * @return
	 */
	public int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();

		// Iterate through each element and add it to the min heap
		for (int num : nums) {
			minHeap.offer(num);

			// if min heap size exceeds k, remove the min value
			if (minHeap.size() > k) {
				minHeap.poll();
			}
		}

		// since the min heap will have the size k, the top element will be the Kth
		// largest
		return minHeap.peek();
	}
}
