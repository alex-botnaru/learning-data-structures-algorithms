package com.abotnaru.problems.neetcode.math;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Detects if there is a square in the stream of points
 */
public class DetectSquares {

	List<int[]> points = new ArrayList<>();
	Map<String, Integer> map = new HashMap<>();

	/**
	 * Adds the point to the stream, duplicate points are considered separate points
	 * 
	 * @param point
	 */
	public void add(int[] point) {
		points.add(point);
		String key = point[0] + "-" + point[1];
		map.put(key, map.getOrDefault(key, 0) + 1);
	}

	/**
	 * Return the number of squares that can be form with the provided point and
	 * with the points in the stream.
	 * 
	 * @param point
	 * @return
	 */
	public int count(int[] point) {
		int count = 0;
		int x = point[0];
		int y = point[1];

		for (int[] p : points) {
			int pX = p[0];
			int pY = p[1];

			// Skip if it is not a square diagonal
			if (Math.abs(pX - x) != Math.abs(pY - y) || pX == x || pY == y) {
				continue;
			}

			// If two points can form a square, then ABS(PX - X) == ABS(PY - Y)
			count += map.getOrDefault(pX + "-" + y, 0) * map.getOrDefault(x + "-" + pY, 0);
		}

		return count;
	}
}
