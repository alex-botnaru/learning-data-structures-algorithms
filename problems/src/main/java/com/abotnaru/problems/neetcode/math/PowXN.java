package com.abotnaru.problems.neetcode.math;

public class PowXN {

	/**
	 * Calculates the x raised to the power of n
	 * 
	 * @param x
	 * @param n
	 * @return
	 */
	public double myPow(double x, int n) {

		// base case, if x is 0, return 0
		if (x == 0) {
			return 0;
		}

		// base case, any number to power of 0 is equal to 1
		if (n == 0) {
			return 1;
		}

		// Recursively compute the x to power of absolute value of n/2
		double result = myPow(x, Math.abs(n) / 2);
		// Multiply the result by itself, eg: 2^4 = 2^2 * 2^2
		result *= result;
		// If the absolute value of n%2 is odd, multiply one more time with x, eg: 2^3 =
		// 2 * 2^2
		if (Math.abs(n) % 2 != 0) {
			result *= x;
		}

		// if power number is negative, divide 1 by result
		if (n < 0) {
			result = 1 / result;
		}

		return result;
	}
}
