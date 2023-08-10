package com.abotnaru.problems.neetcode.math;

public class RotateImage {

	/**
	 * Rotates the value in the matrix by 90 degrees (clockwise). Rotation is done
	 * in place, no additional structure is used. The matrix is expected to be
	 * square.
	 * 
	 * @param matrix
	 */
	public void rotate(int[][] matrix) {

		int left = 0;
		int right = matrix.length - 1;
		// Iterate from outer level to inner ones
		while (left < right) {

			// Iterate through all items on the same level.
			for (int i = 0; i < right - left; i++) {
				int top = left;
				int bottom = right;

				// Save top-left value
				int topLeft = matrix[top][left + i];

				// Move bottom-left to top-left
				matrix[top][left + i] = matrix[bottom - i][left];

				// Move bottom-right to bottom-left
				matrix[bottom - i][left] = matrix[bottom][right - i];

				// Move top-right to bottom-right
				matrix[bottom][right - i] = matrix[top + i][right];

				// Move the top-left value to the top-right
				matrix[top + i][right] = topLeft;
			}
			// Shift pointers to inner level.
			left++;
			right--;

		}

	}
}
