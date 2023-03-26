package com.abotnaru.problems.neetcode.graphs;

public class NumberOfIslands {

	/**
	 * Returns the number of islands in the grid marked by '1'.
	 * 
	 * @param grid
	 * @return
	 */
	public int numIslands(char[][] grid) {

		int count = 0;
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[0].length; col++) {
				if (isIsland(grid, row, col)) {
					count++;
				}
			}
		}
		return count;
	}

	private boolean isIsland(char[][] grid, int row, int col) {
		// If row or col out of bonds, or not an island, return false
		if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == '0') {
			return false;
		}

		// Mark the island as water (visited) and also its neighbors using BFS
		grid[row][col] = '0';
		isIsland(grid, row + 1, col);
		isIsland(grid, row - 1, col);
		isIsland(grid, row, col + 1);
		isIsland(grid, row, col - 1);

		return true;
	}

}
