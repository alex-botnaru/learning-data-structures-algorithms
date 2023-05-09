package com.abotnaru.problems.neetcode.intervals;

import java.util.Arrays;

public class MeetingRooms {

	/**
	 * Returns true if a person can attend all the meetings (meaning there is no
	 * overlap), false otherwise
	 * 
	 * @param intervals
	 * @return
	 */
	public boolean canAttendMeetings(int[][] intervals) {

		// Sort the input array
		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i][0] < intervals[i - 1][1]) {
				// If previous overlaps with current, return false immediately
				return false;
			}
		}

		return true;
	}
}
