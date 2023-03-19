package com.abotnaru.problems.neetcode.heaps;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TaskScheduler {

	/**
	 * For given list of tasks and cool down period, return the least number of
	 * units of time to complete all the tasks.
	 * 
	 * @param tasks
	 * @param n
	 * @return
	 */
	public int leastInterval(char[] tasks, int n) {

		if (n == 0)
			return tasks.length;

		Map<Character, Integer> occMap = new HashMap<>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		Queue<int[]> queue = new LinkedList<>();
		int time = 0;
		// Compute occurrences of all tasks
		for (char task : tasks) {
			occMap.computeIfAbsent(task, k -> 0);
			occMap.put(task, occMap.get(task) + 1);
		}

		// Add task occurrences to the maxHeap
		for (Integer task : occMap.values()) {
			maxHeap.offer(task);
		}

		while (!(maxHeap.isEmpty() && queue.isEmpty())) {

			time++;
			if (!maxHeap.isEmpty()) {
				// Get the max task occurrence, decrement it by one and add it to the queue with
				// the time when next time this will be able to execute, ignore if 0
				int task = maxHeap.poll() - 1;
				if (task > 0) {
					queue.add(new int[] { time + n, task });
				}

			}

			if (!queue.isEmpty() && queue.peek()[0] == time) {
				// if time of the first queue element is equal with the current time, remove the
				// first element and add its occurrence back into the heap
				int[] pair = queue.poll();
				maxHeap.offer(pair[1]);
			}
		}

		return time;
	}

}
