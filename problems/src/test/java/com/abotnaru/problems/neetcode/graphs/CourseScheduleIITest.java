package com.abotnaru.problems.neetcode.graphs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class CourseScheduleIITest {

	@Test
	void testFindOrderAndExpectArrayOfTwo() {
		int[] result = new CourseScheduleII().findOrder(2, new int[][] { { 1, 0 } });
		assertNotNull(result);
		assertEquals(2, result.length);
		assertEquals(0, result[0]);
		assertEquals(1, result[1]);
	}

	@Test
	void testFindOrderAndExpectArrayOfFour() {
		int[] result = new CourseScheduleII().findOrder(4, new int[][] { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } });
		assertNotNull(result);
		assertEquals(4, result.length);
		assertEquals(0, result[0]);
		assertEquals(1, result[1]);
		assertEquals(2, result[2]);
		assertEquals(3, result[3]);
	}

	@Test
	void testFindOrderAndExpectArrayOfOne() {
		int[] result = new CourseScheduleII().findOrder(1, new int[][] {});
		assertNotNull(result);
		assertEquals(1, result.length);
		assertEquals(0, result[0]);
	}

	@Test
	void testFindOrderAndExpectEmptyArray() {
		int[] result = new CourseScheduleII().findOrder(2, new int[][] { { 1, 0 }, {0, 1} });
		assertNotNull(result);
		assertEquals(0, result.length);
	}
}
