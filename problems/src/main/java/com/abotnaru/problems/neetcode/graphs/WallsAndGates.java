package com.abotnaru.problems.neetcode.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {

	/**
	 * Updates the rooms (INF) with the distance to the nearest gate (0), ignoring
	 * the walls (-1)
	 * 
	 * @param rooms
	 */
	public void wallsAndGates(int[][] rooms) {
		final int rows = rooms.length;
		final int cols = rooms[0].length;
		Queue<int[]> queue = new LinkedList<>();
		int[][] directions = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

		// Add gates to the queue
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				if (rooms[row][col] == 0) {
					queue.add(new int[] { row, col });
				}
			}
		}

		while (!queue.isEmpty()) {
			int cells = queue.size();
			for (int i = 0; i < cells; i++) {
				// Extract one level of cells from the queue
				int[] cell = queue.poll();
				int value = rooms[cell[0]][cell[1]] + 1; // Compute the next distance from the current cell
				// check the neighbors cells
				for (int[] dr : directions) {
					int row = cell[0] + dr[0];
					int col = cell[1] + dr[1];
					// Skip if out of bound or is a visited room
					if (row < 0 || row >= rows || col < 0 || col >= cols || rooms[row][col] < value) {
						continue;
					}
					// Update the room/cell value and add it to the queue
					rooms[row][col] = value;
					queue.add(new int[] { row, col });
				}

			}

		}

	}
}
