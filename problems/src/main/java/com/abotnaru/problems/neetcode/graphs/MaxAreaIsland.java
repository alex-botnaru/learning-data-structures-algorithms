package com.abotnaru.problems.neetcode.graphs;

public class MaxAreaIsland {

	/**
	 * Returns the maximum area of an island in the grid. If there is no island
	 * return 0.
	 * 
	 * @param grid
	 * @return
	 */
	public int maxAreaOfIsland(int[][] grid) {
		int maxArea = 0;
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[0].length; col++) {
				// Loop through each cell in the grid, if it is a island, compute the area and
				// update the max value.
				if (grid[row][col] == 1) {
					maxArea = Math.max(maxArea, computeIslandArea(grid, row, col));
				}
			}
		}
		return maxArea;
	}

	/**
	 * Helper DFS function to compute the area of neighbors cells
	 * 
	 * @param grid
	 * @param row
	 * @param col
	 * @return
	 */
	private int computeIslandArea(int[][] grid, int row, int col) {
		// check the boundaries or if it is water
		if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 0) {
			return 0;
		}

		// If it is island, area is one, check neighbors cells and update the count
		int count = 1;
		grid[row][col] = 0;
		count += computeIslandArea(grid, row + 1, col);
		count += computeIslandArea(grid, row - 1, col);
		count += computeIslandArea(grid, row, col + 1);
		count += computeIslandArea(grid, row, col - 1);
		return count;
	}

}
