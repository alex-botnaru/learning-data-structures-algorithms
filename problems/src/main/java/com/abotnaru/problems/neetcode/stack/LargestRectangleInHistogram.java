package com.abotnaru.problems.neetcode.stack;

import java.util.Stack;

public class LargestRectangleInHistogram {

	static class Pair {
		int index;
		int value;

		Pair(int index, int value) {
			this.index = index;
			this.value = value;
		}
	}

	/**
	 * Returns the largest rectangle area created by the input number histogram.
	 * <p>
	 * Time and space complexity O(N). Requires a key-value data structure.
	 * 
	 * @param heights
	 * @return
	 */
	public int largestRectangleArea(int[] heights) {
		int maxArea = 0;
		Stack<Pair> stack = new Stack<>();
		// Iterate through all elements and push them to the stack.
		// The stack will contain index - height value pair
		for (int i = 0; i < heights.length; i++) {
			int height = heights[i];
			int start = i;
			while (!stack.isEmpty() && stack.peek().value > height) {
				// If the current height is smaller than previous, this means the previous
				// cannot be extended, so we remove it from the stack. Compute the are previous
				// element could create, and update the start index for the current pair.
				Pair pair = stack.pop();
				maxArea = Math.max(maxArea, pair.value * (i - pair.index));
				start = pair.index;
			}
			// Push the updated start index and the height pair to the stack.
			// The heights in the stack will always be in the increasing order.
			stack.push(new Pair(start, height));
		}

		// Calculate the area for the remaining heights in stack.
		while (!stack.isEmpty()) {
			Pair pair = stack.pop();
			maxArea = Math.max(maxArea, pair.value * (heights.length - pair.index));
		}

		return maxArea;
	}

	/**
	 * Returns the largest rectangle area created by the input number histogram.
	 * <p>
	 * This solution is the brute force approach. Time complexity is O(N^2), space
	 * complexity is O(1)
	 * 
	 * @param heights
	 * @return
	 */
	public int largestRectangleAreaBruteForce(int[] heights) {
		int maxArea = heights.length > 0 ? heights[0] : 0;
		for (int i = 0; i < heights.length; i++) {
			// Iterate through all elements.
			int minHeight = heights[i];
			int len = 1;
			// Compute all area combination with remaining elements.
			for (int j = i + 1; j < heights.length; j++) {
				minHeight = Math.min(minHeight, heights[j]);
				len++;
				int area = minHeight * len;
				if (maxArea < area) {
					maxArea = area;
				}
			}

		}
		return maxArea;
	}

}
