package com.abotnaru.problems.neetcode.math;

public class MatrixZeroes {

	/**
	 * If an element is 0, set the row and column to 0.
	 * <p>
	 * Solution with constant time space complexity
	 * 
	 * @param matrix
	 */
	public void setZeroes(int[][] matrix) {

		boolean rowZero = false; // Variable to indicate if first row has to be set to 0

		// Loop through each element, if its 0, mark the column to be set to 0 in the
		// first row, and mark the row to be set to zero in the first column
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[0].length; col++) {
				if (matrix[row][col] == 0) {
					matrix[0][col] = 0;
					if (row > 0) {
						matrix[row][0] = 0;
					} else {
						rowZero = true;
					}
				}
			}
		}

		// Starting at second row and column, if the row or column are marked as zero in
		// the first row/column, set the element as 0
		for (int row = 1; row < matrix.length; row++) {
			for (int col = 1; col < matrix[0].length; col++) {
				if (matrix[0][col] == 0 || matrix[row][0] == 0) {
					matrix[row][col] = 0;
				}
			}
		}

		// set first column to 0 if needed
		if (matrix[0][0] == 0) {
			for (int row = 0; row < matrix.length; row++) {
				matrix[row][0] = 0;
			}
		}

		// Set first row to 0 if needed
		if (rowZero) {
			for (int col = 0; col < matrix[0].length; col++) {
				matrix[0][col] = 0;
			}
		}

	}
}
