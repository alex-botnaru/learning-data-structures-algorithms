package com.abotnaru.problems.neetcode.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

	public int[][] merge(int[][] intervals) {
		List<int[]> result = new ArrayList<>();

		// Sort the input array by start value
		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

		// Set the first interval as previous
		int[] previous = intervals[0];
		for (int i = 1; i < intervals.length; i++) {

			if (previous[1] < intervals[i][0]) {
				// If previous interval doesn't overlap with the current one, add it to the
				// output array, and set the current as previous
				result.add(previous);
				previous = intervals[i];
			} else {
				// If the do overlap, merge the previous with the current
				previous[0] = Math.min(previous[0], intervals[i][0]);
				previous[1] = Math.max(previous[1], intervals[i][1]);
			}
		}
		// And the remaining interval to the output
		result.add(previous);
		return result.toArray(new int[result.size()][]);
	}
}
