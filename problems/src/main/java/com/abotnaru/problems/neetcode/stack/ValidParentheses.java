package com.abotnaru.problems.neetcode.stack;

import java.util.Stack;

public class ValidParentheses {

	/**
	 * Returns true if the input string contains parentheses characters and they
	 * open and close in the right order.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isValid(String input) {
		if (input == null || input.length() < 2) {
			return false;
		}

		Stack<Character> stack = new Stack<>();

		for (char c : input.toCharArray()) {
			if (isOpening(c)) {
				// Add each open bracket to the stack and skip the rest of the loop code
				stack.push(c);
				continue;
			} else if (stack.isEmpty()) {
				// Special case when the character is a closing bracket but the stack is empty,
				// meaning there is no opening bracket for the current bracket.
				return false;
			}

			// c here means a closing bracket, check if has a matching open bracket in the
			// stack
			char top = stack.peek();
			if ((top == '(' && c == ')') || (top == '[' && c == ']') || (top == '{' && c == '}')) {
				// Pop if there is a matching
				stack.pop();
			} else {
				return false;
			}

		}

		return stack.isEmpty();
	}

	private boolean isOpening(char c) {
		return c == '(' || c == '[' || c == '{';
	}

}
