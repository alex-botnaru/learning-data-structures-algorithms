package com.abotnaru.problems.neetcode.math;

public class MultiplyStrings {

	/**
	 * Multiplies non-negative input integers in form of strings and return the
	 * result as a string
	 * 
	 * @param num1
	 * @param num2
	 * @return
	 */
	public String multiply(String num1, String num2) {

		// Create the output array
		int[] product = new int[num1.length() + num2.length()];

		// Loop backward as we do on the paper
		for (int i = num2.length() - 1; i > -1; i--) {
			for (int j = num1.length() - 1; j > -1; j--) {
				// Extract the digits from the string
				int n1 = num1.charAt(j) - '0';
				int n2 = num2.charAt(i) - '0';
				int p = n2 * n1 + product[i + j + 1]; // compute the product + carry from previous operation
				product[i + j + 1] = p % 10; // Store the result
				product[i + j] += p / 10; // Store the carry
			}
		}
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < product.length; i++) {
			if (i == 0 && product[i] == 0) {
				// Skip the first digit if it's leading 0
				continue;
			}
			// Append digit to the output string
			builder.append(product[i]);
		}

		return builder.toString();
	}
}
