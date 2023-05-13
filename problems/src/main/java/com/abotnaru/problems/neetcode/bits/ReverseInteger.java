package com.abotnaru.problems.neetcode.bits;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;

public class ReverseInteger {

	/**
	 * Returns the value of the input string with digits reversed, if the reversed
	 * values exceeds the 32-bits integer range, returns 0 instead.
	 * 
	 * @param x
	 * @return
	 */
	public int reverse(int x) {
		int result = 0;

		while (x != 0) {

			// Get current digit and remove it from the input number
			int digit = x % 10;
			x = x / 10;

			// Check the boundaries of the reversed string
			if (result > MAX_VALUE / 10 || (result == MAX_VALUE / 10 && digit >= MAX_VALUE % 10)) {
				return 0;
			}

			if (result < MIN_VALUE / 10 || (result == MIN_VALUE / 10 && digit <= MIN_VALUE % 10)) {
				return 0;
			}

			// Add the digit to the output number
			result = (result * 10) + digit;
		}
		return result;
	}
}
