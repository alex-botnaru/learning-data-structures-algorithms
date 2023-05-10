package com.abotnaru.problems.neetcode.math;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	/**
	 * Return all elements of the matrix in spiral order
	 * 
	 * @param matrix
	 * @return
	 */
	public List<Integer> spiralOrder(int[][] matrix) {
		int left = 0;
		int top = 0;
		int right = matrix[0].length;
		int bottom = matrix.length;
		List<Integer> result = new ArrayList<>();

		while (left < right && top < bottom) {

			// Get every element in the top row
			for (int i = left; i < right; i++) {
				result.add(matrix[top][i]);
			}
			top++; // Shift top row down

			// Get every element in the right column
			for (int i = top; i < bottom; i++) {
				result.add(matrix[i][right - 1]);
			}
			right--; // Shift right column to left

			// Special condition, otherwise it will ad an extra element
			if (!(left < right && top < bottom)) {
				break;
			}

			// Get every element in the bottom row
			for (int i = right - 1; i >= left; i--) {
				result.add(matrix[bottom - 1][i]);
			}
			bottom--; // Shift bottom row up

			// Get every element in the left column
			for (int i = bottom - 1; i >= top; i--) {
				result.add(matrix[i][left]);
			}
			left++; // Shift the left column to the right

		}

		return result;
	}
}
