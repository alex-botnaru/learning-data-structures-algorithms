package com.abotnaru.problems.neetcode.heaps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class KClosestOriginPointsTest {

	@Test
	void testKClosestPointsAndExpectOnePoint() {
		int[][] result = new KClosestOriginPoints().kClosest(new int[][] { { 1, 3 }, { -2, 2 } }, 1);
		assertNotNull(result);
		assertEquals(1, result.length);
	}

	@Test
	void testKClosestPointsAndExpectTwoPoints() {
		int[][] result = new KClosestOriginPoints().kClosest(new int[][] { { 3, 3 }, { 5, -1 }, { -2, 4 } }, 2);
		assertNotNull(result);
		assertEquals(2, result.length);
	}
}
