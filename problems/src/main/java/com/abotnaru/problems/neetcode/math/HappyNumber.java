package com.abotnaru.problems.neetcode.math;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

	/**
	 * Return whatever the number is happy or not
	 * 
	 * @param n
	 * @return
	 */
	public boolean isHappy(int n) {

		int num = n;
		// Instantiate a set to track cycles
		Set<Integer> set = new HashSet<>();

		while (set.add(num)) { // While we are not in the cycle
			int sum = 0;
			// Compute the sum
			while (num > 0) {
				int digit = num % 10; // Get last digit
				sum += (digit * digit); // add the square to the sum
				num /= 10; // move to next digit
			}

			if (sum == 1) {
				// if we get to 1, we found happy number
				return true;
			}
			num = sum;

		}

		return false;
	}
}
