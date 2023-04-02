package com.abotnaru.problems.neetcode.graphs;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow {

	/**
	 * Returns a list of coordinates that can flow in both oceans.
	 * 
	 * @param heights
	 * @return
	 */
	public List<List<Integer>> pacificAtlantic(int[][] heights) {
		final int rows = heights.length;
		final int cols = heights[0].length;
		List<List<Integer>> result = new ArrayList<>();
		boolean[][] pacific = new boolean[rows][cols];
		boolean[][] atlantic = new boolean[rows][cols];

		for (int row = 0; row < rows; row++) {
			// Left edge always flow into Pacific, check next cells that flow into Pacific,
			// too
			dfsFlow(heights, row, 0, Integer.MIN_VALUE, pacific);
			// Right edge always flow into Atlantic, check next cells that flow into
			// Atlantic, too
			dfsFlow(heights, row, cols - 1, Integer.MIN_VALUE, atlantic);
		}

		for (int col = 0; col < cols; col++) {
			// Top edge always flow into Pacific, check next cells that flow into Pacific,
			// too
			dfsFlow(heights, 0, col, Integer.MIN_VALUE, pacific);
			// Bottom edge always flow into Atlantic, check next cells that flow into
			// Atlantic, too
			dfsFlow(heights, rows - 1, col, Integer.MIN_VALUE, atlantic);
		}

		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				// If the cell flows in both oceans, add it to the result list
				if (pacific[row][col] && atlantic[row][col]) {
					result.add(List.of(row, col));
				}
			}
		}

		return result;
	}

	/**
	 * Helper DFS function
	 * 
	 * @param heights
	 * @param row
	 * @param col
	 * @param prevVal
	 * @param ocean
	 */
	private void dfsFlow(int[][] heights, int row, int col, int prevVal, boolean[][] ocean) {
		final int rows = heights.length;
		final int cols = heights[0].length;
		// Check if coordinates are out of bound, or it doesn't flow into previous cell,
		// or has been already visited
		if (row < 0 || row >= rows || col < 0 || col >= cols || heights[row][col] < prevVal || ocean[row][col]) {
			return;
		}
		// Mark the cell as it flows into the ocean
		ocean[row][col] = true;
		// Visit the neighbors and check if they flow into the current cell
		dfsFlow(heights, row + 1, col, heights[row][col], ocean);
		dfsFlow(heights, row - 1, col, heights[row][col], ocean);
		dfsFlow(heights, row, col + 1, heights[row][col], ocean);
		dfsFlow(heights, row, col - 1, heights[row][col], ocean);
	}
}
