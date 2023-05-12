package com.abotnaru.problems.neetcode.bits;

public class NumberOfOneBits {

	/**
	 * Returns the number of 1 bits in the input n
	 * 
	 * @param n
	 * @return
	 */
	public int hammingWeight(int n) {
		int count = 0;
		while (n != 0) {
			// while we still have 1 bits
			if ((n & 1) == 1) {
				// If last bit is 1, increment the count
				count++;
			}
			// Shift one bit to the right
			n = n >> 1;

			// An alternative approach is to skip all the 0s
			// n = n & (n -1);
			// count++;
		}
		return count;
	}
}
