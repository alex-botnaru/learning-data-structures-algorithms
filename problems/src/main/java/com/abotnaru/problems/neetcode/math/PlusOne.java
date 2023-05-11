package com.abotnaru.problems.neetcode.math;

public class PlusOne {

	/**
	 * Increment the input integer (array of digit) by one and return result into
	 * array
	 * 
	 * @param digits
	 * @return
	 */
	public int[] plusOne(int[] digits) {
		// Initialize output array
		int[] result = new int[digits.length];
		int carry = 1; // Initialize carry with one, this it what will be added to last digit

		for (int i = digits.length - 1; i > -1; i--) {
			// Compute sum and carry and add it to output array
			int sum = carry + digits[i];
			carry = sum / 10;
			sum = sum % 10;
			result[i] = sum;
		}

		// Special case when we still have carry, increment the size array by one and
		// add the carry at the start of the number
		if (carry > 0) {
			int[] newResult = new int[result.length + 1];
			newResult[0] = carry;
			for (int i = 1; i < newResult.length; i++) {
				newResult[i] = result[i - 1];
			}
			result = newResult;
		}
		return result;
	}
}
