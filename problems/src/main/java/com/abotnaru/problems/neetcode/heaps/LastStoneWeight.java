package com.abotnaru.problems.neetcode.heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {

	/**
	 * Returns the last stone weight after smashing all stones.
	 * 
	 * @param stones
	 * @return
	 */
	public int lastStoneWeight(int[] stones) {

		if (stones == null || stones.length == 0)
			return 0;

		// Use a max heap to store stone weights
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		for (int stone : stones) {
			maxHeap.offer(stone);
		}

		while (maxHeap.size() > 1) {
			// Pick the last two heaviest stones
			int stone1 = maxHeap.poll();
			int stone2 = maxHeap.poll();
			// Smash them and store the remaining weight in the max heap
			int result = Math.abs(stone1 - stone2);
			if (result > 0) {
				maxHeap.offer(result);
			}
		}

		return maxHeap.isEmpty() ? 0 : maxHeap.peek();
	}

}
