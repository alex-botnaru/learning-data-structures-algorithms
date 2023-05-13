package com.abotnaru.problems.neetcode.bits;

public class ReverseBits {

	/**
	 * Reverse the bits of the input value
	 * 
	 * @param n
	 * @return
	 */
	public int reverseBits(int n) {

		int result = 0;

		// Loop through all the bits
		for (int i = 0; i < 32; i++) {
			result <<= 1; // Shift the result bit by one to the left
			result |= (n & 1); // Set the current bit to the last bit in the n
			n >>= 1; // Shift the n one bit to the right
		}

		return result;
	}
}
