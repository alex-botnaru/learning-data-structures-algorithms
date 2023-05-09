package com.abotnaru.problems.neetcode.intervals;

import java.util.Arrays;

public class NonOverlappingIntervals {

	/**
	 * Returns the minimum number of intervals to be removed to make the rest of
	 * intervals non-overlapping
	 * 
	 * @param intervals
	 * @return
	 */
	public int eraseOverlapIntervals(int[][] intervals) {
		// Sort the input array by start value
		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
		int count = 0;
		// get the end of the first interval
		int prevEnd = intervals[0][1];
		for (int i = 1; i < intervals.length; i++) {
			if (prevEnd > intervals[i][0]) {
				// If previous overlaps with current, one needs to be removed, increment the
				// count.
				count++;
				// Remove the longest interval, as it may overlap multiple short ones.
				prevEnd = Math.min(prevEnd, intervals[i][1]);
			} else {
				// Non-overlapping, just update the previous end.
				prevEnd = intervals[i][1];
			}
		}
		return count;
	}
}
