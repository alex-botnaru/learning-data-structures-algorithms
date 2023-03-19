package com.abotnaru.problems.neetcode.heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {

	// Max priority queue for the elements from the left, all left elements are
	// smaller than the right. Max element will be closer to median.
	private PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder()); // Max heap

	// Min priority queue for the elements from the right, all the right elements
	// are greater than the left one. Min element will be closer to median.
	private PriorityQueue<Integer> right = new PriorityQueue<>(); // Min Heap

	public void addNum(int num) {

		left.offer(num);
		// Making sure the new added number is placed in the right heap
		if (left.size() - right.size() > 1 || (!right.isEmpty() && left.peek() > right.peek())) {
			right.offer(left.poll());
		}
		if (right.size() - left.size() > 1) {
			left.offer(right.poll());
		}
	}

	public double findMedian() {
		double result = 0;
		if (left.size() == right.size()) {
			// Even stream length, calculate the median
			result = (left.peek() + right.peek()) / 2.0;
		} else if (left.size() > right.size()) {
			result = left.peek();
		} else {
			result = right.peek();
		}
		return result;
	}
}
