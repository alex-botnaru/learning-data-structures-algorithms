package com.abotnaru.problems.neetcode.intervals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MinimumInterval {

	/**
	 * Returns an array containing answers to the queries. The answer represents the
	 * size of smallest interval containing the query number. If no such interval
	 * exists, the answer will be -1.
	 * 
	 * @param intervals
	 * @param queries
	 * @return
	 */
	public int[] minInterval(int[][] intervals, int[] queries) {

		// Prepare the result array and fill with default values.
		int[] result = new int[queries.length];
		Arrays.fill(result, -1);

		// Sort the interval arrays by left value
		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

		// Create a minHeap to store (interval size, right end value)
		PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

		// Map each query to the index in the original array
		Map<Integer, Integer> indexMap = new HashMap<>();
		for (int i = 0; i < queries.length; i++) {
			indexMap.put(queries[i], i);
		}
		// Sort the queries
		Arrays.sort(queries);

		int index = 0; // Current index that loops through the intervals
		for (int query : queries) {

			// Loop only through intervals where the current query belongs
			while (index < intervals.length && intervals[index][0] <= query) {
				// For each interval, add to the min heap the size of the interval and the end
				// value
				int left = intervals[index][0];
				int right = intervals[index][1];
				minHeap.add(new int[] { right - left + 1, right });
				index++;
			}

			// remove intervals that don't contain current query
			while (!minHeap.isEmpty() && minHeap.peek()[1] < query) {
				minHeap.poll();
			}
			if (!minHeap.isEmpty()) {
				// Update the result array with the size of the min interval
				result[indexMap.get(query)] = minHeap.peek()[0];
			}
		}

		return result;
	}

	public int[] minIntervalInitial(int[][] intervals, int[] queries) {

		int[] result = new int[queries.length];
		Map<Integer, int[]> map = new HashMap<>();

		Arrays.fill(result, -1);
		for (int[] interval : intervals) {

			for (int i = interval[0]; i <= interval[1]; i++) {
				if (!map.containsKey(i)) {
					map.put(i, interval);
					continue;
				}

				int[] current = map.get(i);
				if (current[1] - current[0] > interval[1] - interval[0]) {
					map.put(i, interval);
				}
			}
		}

		for (int i = 0; i < queries.length; i++) {
			if (map.containsKey(queries[i])) {
				result[i] = map.get(queries[i])[1] - map.get(queries[i])[0] + 1;
			}
		}

		return result;
	}
}
