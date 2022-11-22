package com.abotnaru.problems.neetcode.stack;

import java.util.Stack;

public class ReversePolishNotation {

	int evalRPN(String[] tokens) {

		Stack<Integer> operands = new Stack<>();
		for (String token : tokens) {
			if (isOperator(token)) {
				operands.push(evaluate(operands.pop(), operands.pop(), token));
			} else {
				operands.push(Integer.valueOf(token));
			}
		}

		return operands.pop();
	}

	private int evaluate(int operand2, int operand1, String operator) {
		int result = 0;
		switch (operator) {
		case "+":
			result = operand1 + operand2;
			break;
		case "-":
			result = operand1 - operand2;
			break;
		case "*":
			result = operand1 * operand2;
			break;
		case "/":
			result = operand1 / operand2;
			break;
		default:
			throw new IllegalArgumentException("Unsupported operator " + operator);
		}
		return result;
	}

	private boolean isOperator(String token) {
		return "+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token);
	}

}
