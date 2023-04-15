package com.abotnaru.problems.neetcode.advanced.graphs;

import java.util.PriorityQueue;

public class SwimRisingWater {

	/**
	 * Return the minimum elevation to get from the top left corner to the
	 * bottom-right one.
	 * 
	 * @param grid
	 * @return
	 */
	public int swimInWater(int[][] grid) {
		int gridSize = grid.length;
		PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
		boolean[][] visited = new boolean[gridSize][gridSize];
		int[][] directions = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

		// Store top-left corner in the priority queue and mark as visited
		minHeap.add(new int[] { 0, 0, 0 });
		visited[0][0] = true;

		while (!minHeap.isEmpty()) {
			int height = minHeap.peek()[0];
			int row = minHeap.peek()[1];
			int col = minHeap.poll()[2];

			if (row == gridSize - 1 && col == gridSize - 1) {
				// return if we reached the destination
				return height;
			}

			for (int[] direction : directions) {
				// Move in all direction
				int nRow = row + direction[0];
				int nCol = col + direction[1];

				if (nRow < 0 || nRow >= gridSize || nCol < 0 || nCol >= gridSize || visited[nRow][nCol]) {
					// Skip if out of bounds or visited
					continue;
				}
				// Mark the cell as visited and add it to the heap with the max height value to
				// get here
				visited[nRow][nCol] = true;
				minHeap.add(new int[] { Math.max(height, grid[nRow][nCol]), nRow, nCol });
			}
		}
		return -1;
	}

}
