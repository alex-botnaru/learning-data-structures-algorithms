package com.abotnaru.problems.neetcode.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

	/**
	 * Return the minimum number of minutes that must elapse until no cell has a
	 * fresh orange. If this is impossible, return -1.
	 * 
	 * @param grid
	 * @return
	 */
	public int orangesRotting(int[][] grid) {
		int goodOranges = 0;
		int timeCount = 0;
		Queue<int[]> queue = new LinkedList<>();
		final int rows = grid.length;
		final int cols = grid[0].length;
		int[][] directions = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

		// Loop through each grid cell, count the number of good oranges, and add to the
		// queue the cell coordinates of the rotten oranges.
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				if (grid[row][col] == 1) {
					goodOranges++;
				} else if (grid[row][col] == 2) {
					queue.add(new int[] { row, col });
				}
			}
		}

		// While we still have good oranges and queue is not empty
		while (goodOranges > 0 && !queue.isEmpty()) {

			timeCount++;
			int rotted = queue.size();
			for (int i = 0; i < rotted; i++) {
				// Extract only the current time rotted oranges
				int[] gridCell = queue.poll();
				// check the neighbors cells
				for (int[] dr : directions) {
					int row = gridCell[0] + dr[0];
					int col = gridCell[1] + dr[1];
					// if cell coordinates are out of bound or not a fresh orange, skip it
					if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] != 1) {
						continue;
					}
					// Else, mark the cell as rotten orange, add the cell to the queue, and
					// decrement the number of good oranges
					grid[row][col] = 2;
					queue.add(new int[] { row, col });
					goodOranges--;
				}
			}

		}

		// if we still have good oranges, return -1, otherwise return the time count.
		return goodOranges > 0 ? -1 : timeCount;
	}
}
