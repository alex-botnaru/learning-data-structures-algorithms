package com.abotnaru.problems.neetcode.stack;

import java.util.Stack;

public class DailyTemperatures {

	/**
	 * For the input array that represents daily temperature, returns an array of
	 * the same size, such as element at any index, represents how may days need to
	 * wait till a greater temperature. Time complexity and space complexity O(N).
	 * 
	 * @param temperatures
	 * @return
	 */
	public int[] dailyTemperatures(int[] temperatures) {
		int[] result = new int[temperatures.length];
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < temperatures.length; i++) {
			while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
				int index = stack.pop();
				result[index] = i - index;
			}
			stack.push(i);
		}

		return result;
	}

	/**
	 * This is a brute force solution, with O(N^2) time complexity
	 * 
	 * @param temperatures
	 * @return
	 */
	public int[] dailyTemperaturesBruteForce(int[] temperatures) {
		int[] result = new int[temperatures.length];

		for (int i = 0; i < temperatures.length; i++) {
			int maxFinding = 0;
			for (int j = i + 1; j < temperatures.length; j++) {
				if (temperatures[i] < temperatures[j]) {
					result[i] = maxFinding + 1;
					break;
				} else {
					maxFinding++;
				}
			}
		}
		return result;
	}

}
