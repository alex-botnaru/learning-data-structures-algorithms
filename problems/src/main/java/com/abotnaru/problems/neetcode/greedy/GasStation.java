package com.abotnaru.problems.neetcode.greedy;

public class GasStation {

	/**
	 * Returns the starting index to travel around the circuit, if it is not
	 * possible, returns -1.
	 * 
	 * @param gas
	 * @param cost
	 * @return
	 */
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int startIndex = -1;
		int total = 0;

		// Sum up total gas amount minus cost and see if we can complete the loop, if
		// not - return -1
		for (int i = 0; i < gas.length; i++) {
			total += gas[i] - cost[i];
		}
		if (total < 0) {
			return -1;
		}

		// Find the starting position
		total = 0;
		for (int i = 0; i < gas.length; i++) {
			total += gas[i] - cost[i];
			if (total < 0) {
				total = 0;
				startIndex = i + 1;
			}
		}

		return startIndex;
	}
}
