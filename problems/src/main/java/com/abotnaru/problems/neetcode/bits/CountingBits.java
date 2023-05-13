package com.abotnaru.problems.neetcode.bits;

public class CountingBits {

	/**
	 * Return an integer with number of 1's bits in each number from 0 to n
	 * 
	 * @param n
	 * @return
	 */
	public int[] countBits(int n) {

		int[] result = new int[n + 1];
		int offset = 1;

		for (int i = 1; i < result.length; i++) {

			// If offset of power of two is equal to i, the i becomes new offset
			if ((offset << 1) == i) {
				offset = i;
			}
			// Current number will have one bit plus what we have in offset
			result[i] = 1 + result[i - offset];
		}

		return result;
	}
}
