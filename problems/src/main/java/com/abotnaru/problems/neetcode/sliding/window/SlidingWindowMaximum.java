package com.abotnaru.problems.neetcode.sliding.window;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {

	/**
	 * Returns the max for each sliding window. The size of the sliding window is k.
	 * Sliding the window from left to right. Every time the window slides to the
	 * right, the maximum for that window is stored in the output array.
	 * <p>
	 * Time and space complexity O(N).
	 * 
	 * @param nums
	 * @param k
	 * @return
	 */
	public int[] maxSlidingWindow(int[] nums, int k) {
		int[] result = new int[nums.length - k + 1];

		Deque<Integer> deque = new LinkedList<>(); // Store the indexes of the values in the sliding window
		int left = 0;
		int right = 0;

		while (right < nums.length) {

			while (!deque.isEmpty() && nums[right] > nums[deque.peekLast()]) {
				// Remove any small elements from the end of the queue, they will not be used
				// again.
				deque.removeLast();
			}
			// Add the new window element to the end.
			deque.addLast(right);

			if (left > deque.peekFirst()) {
				// Remove out of range max elements from the front of the queue
				deque.removeFirst();
			}

			if (right + 1 >= k) {
				// Update output array and move left pointer to the right when there is a valid
				// window size.
				result[right + 1 - k] = nums[deque.peekFirst()];
				left++;
			}

			right++;
		}
		return result;
	}

	/**
	 * Initial implementation using priority queue. Time complexity is O(NlogK)
	 * 
	 * @param nums
	 * @param k
	 * @return
	 */
	public int[] maxSlidingWindowPriorityQueue(int[] nums, int k) {
		int[] result = new int[nums.length - k + 1];
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b.compareTo(a));
		int left = 0;
		for (int right = 0; right < nums.length; right++) {
			// Add the element to the heap
			maxHeap.add(nums[right]);

			if (right + 1 >= k) {
				// Add the max element to the output array
				result[right + 1 - k] = maxHeap.peek();
				// Remove the left element and move the left pointer to the right
				maxHeap.remove(nums[left]);
				left++;
			}
		}
		return result;
	}

}
