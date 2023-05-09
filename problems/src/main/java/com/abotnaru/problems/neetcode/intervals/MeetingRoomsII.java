package com.abotnaru.problems.neetcode.intervals;

import java.util.Arrays;

public class MeetingRoomsII {

	/**
	 * Returns the minimum number of conference rooms.
	 * 
	 * @param intervals
	 * @return
	 */
	public int minMeetingRooms(int[][] intervals) {

		// Store the start and end times into separate arrays and sort them
		int[] starts = new int[intervals.length];
		int[] ends = new int[intervals.length];
		for (int i = 0; i < intervals.length; i++) {
			starts[i] = intervals[i][0];
			ends[i] = intervals[i][1];
		}

		Arrays.sort(starts);
		Arrays.sort(ends);

		int result = 0;
		int count = 0;
		int startIdx = 0;
		int endIdx = 0;

		// While there is a meeting that have not started
		while (startIdx < starts.length) {

			if (starts[startIdx] < ends[endIdx]) {
				// if meeting starts while another is running, increment the start index and the
				// room count
				startIdx++;
				count++;
			} else {
				// A meeting has ended, increment the end index and decrement the room count
				endIdx++;
				count--;
			}
			// Record the number of max meeting rooms
			result = Math.max(result, count);
		}

		return result;
	}
}
