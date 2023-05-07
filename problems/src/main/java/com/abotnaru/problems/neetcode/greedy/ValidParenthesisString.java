package com.abotnaru.problems.neetcode.greedy;

public class ValidParenthesisString {

	/**
	 * Returns true if the string contains the right number of open and close
	 * parenthesis and in the right order.
	 * 
	 * @param s
	 * @return
	 */
	public boolean checkValidString(String s) {

		int leftMin = 0;
		int leftMax = 0;

		for (char c : s.toCharArray()) {
			if (c == '(') {
				leftMin++;
				leftMax++;
			} else if (c == ')') {
				leftMin--;
				leftMax--;
			} else {
				// Two possibilities for the "*", either use as "(" or ")"
				leftMin--;
				leftMax++;
			}

			if (leftMax < 0) {
				// invalid case
				return false;
			}

			if (leftMin < 0) {
				leftMin = 0;
			}
		}
		return leftMin == 0;
	}
}
