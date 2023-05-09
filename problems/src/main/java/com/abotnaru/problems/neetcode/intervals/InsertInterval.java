package com.abotnaru.problems.neetcode.intervals;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

	/**
	 * Returns the intervals after adding new intervals and combining overlapping
	 * intervals.
	 * 
	 * @param intervals
	 * @param newInterval
	 * @return
	 */
	public int[][] insert(int[][] intervals, int[] newInterval) {
		List<int[]> result = new ArrayList<>();
		for (int[] interval : intervals) {

			if (newInterval == null || interval[1] < newInterval[0]) {
				// Just add any interval that don't overlap with the new one
				result.add(interval);
			} else if (interval[0] > newInterval[1]) {
				// First interval that is greater than new interval, add the new interval and
				// the next interval, then set the new interval as null to not be added anymore
				result.add(newInterval);
				result.add(interval);
				newInterval = null;
			} else {
				// Interval overlaps, update the new interval range
				newInterval[0] = Math.min(newInterval[0], interval[0]);
				newInterval[1] = Math.max(newInterval[1], interval[1]);
			}

		}

		if (newInterval != null) {
			// edge case when the interval is last and non-overlapping
			result.add(newInterval);
		}

		return result.toArray(new int[result.size()][]);
	}
}
