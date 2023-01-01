package com.abotnaru.problems.neetcode.binary.search;

public class Search2DMatrix {

	/**
	 * Return true if the target value exists in the matrix.
	 * <p>
	 * All the numbers in the matrix are sorted in ascending order.
	 * <p>
	 * Time complexity is O(log (M*N))
	 * 
	 * @param matrix
	 * @param target
	 * @return
	 */
	public boolean searchMatrix(int[][] matrix, int target) {

		if (matrix.length == 0)
			return false;

		int start = 0;
		int cols = matrix[0].length;
		// We know that all the row elements are sorted in ascending order, and the
		// first integer of the row is greater than any element on the previous row. So
		// we can consider the matrix as one continuous uni-dimensional array.
		int end = matrix.length * cols;

		while (start <= end) {
			int middle = (start + end) / 2;
			// middle / cols = row index
			// middle % cols = column index
			if (matrix[middle / cols][middle % cols] == target) {
				return true;
			} else if (matrix[middle / cols][middle % cols] < target) {
				start = middle + 1;
			} else {
				end = middle - 1;
			}
		}

		return false;
	}

	/**
	 * Return true if the target value exists in the matrix.
	 * <p>
	 * All the numbers in the matrix are sorted in ascending order.
	 * <p>
	 * This is the initial implementation, time complexity O(log M + log N)
	 * 
	 * @param matrix
	 * @param target
	 * @return
	 */
	public boolean searchMatrixInital(int[][] matrix, int target) {
		int rowStart = 0;
		int rowEnd = matrix.length - 1;
		int searchRow = -1;

		// First, we search for the row that might contain the value
		while (rowStart <= rowEnd) {
			int rowMiddle = (rowStart + rowEnd) / 2;
			int colStart = 0;
			int colEnd = matrix[rowMiddle].length - 1;

			if (target > matrix[rowMiddle][colEnd]) {
				rowStart = rowMiddle + 1;
			} else if (target < matrix[rowMiddle][colStart]) {
				rowEnd = rowMiddle - 1;
			} else {
				searchRow = rowMiddle;
				break; // Break the loop if row was found
			}

		}

		// If we found a potential row, do a binary search to check if the element is in
		// there.
		if (searchRow > -1) {
			int colStart = 0;
			int colEnd = matrix[searchRow].length - 1;
			while (colStart <= colEnd) {
				int colMiddle = (colStart + colEnd) / 2;
				if (matrix[searchRow][colMiddle] == target) {
					return true;
				} else if (target > matrix[searchRow][colMiddle]) {
					colStart = colMiddle + 1;
				} else {
					colEnd = colMiddle - 1;
				}
			}
		}

		return false;
	}

}
