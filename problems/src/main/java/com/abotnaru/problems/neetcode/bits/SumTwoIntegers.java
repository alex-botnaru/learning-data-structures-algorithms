package com.abotnaru.problems.neetcode.bits;

public class SumTwoIntegers {

	/**
	 * Adds two number together without using + or - operators
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public int getSum(int a, int b) {

		while (b != 0) {
			// First compute carry values and shift it by one. Use a temporary carry
			// variable to use the original value
			int carry = (a & b) << 1;
			// do XOR on first value
			a = a ^ b;
			// assign the carry to the second value and repeat until the carry is 0
			b = carry;
		}
		return a;
	}
}
