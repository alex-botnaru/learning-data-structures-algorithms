package com.abotnaru.problems.neetcode.heaps;

import java.util.PriorityQueue;

public class KClosestOriginPoints {

	public int[][] kClosest(int[][] points, int k) {

		// Use max heap so we can keep the points with smallest distance from origin
		PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
				(a, b) -> Integer.compare((b[0] * b[0] + b[1] * b[1]), (a[0] * a[0] + a[1] * a[1])));

		// Add the points to the max heap. Remove farthest points if heap size is
		// greater than k
		for (int[] point : points) {
			maxHeap.offer(point);

			if (maxHeap.size() > k) {
				maxHeap.poll();
			}
		}

		// Create the result array
		int[][] result = new int[k][2];
		for (int i = 0; i < k; i++) {
			int[] point = maxHeap.poll();
			result[i][0] = point[0];
			result[i][1] = point[1];
		}

		return result;
	}
}
