package com.abotnaru.problems.neetcode.heaps;

import java.util.PriorityQueue;

public class KthLargestStreamElement {

	private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	private int k;

	public KthLargestStreamElement(int k, int[] nums) {
		this.k = k;
		for (int num : nums) {
			add(num);
		}
	}

	/**
	 * Adds a value to the stream and returns the Kth largest value
	 * 
	 * @param val
	 * @return
	 */
	public int add(int val) {
		minHeap.offer(val);
		if (minHeap.size() > k) {
			minHeap.poll();
		}
		return minHeap.peek();
	}

}
