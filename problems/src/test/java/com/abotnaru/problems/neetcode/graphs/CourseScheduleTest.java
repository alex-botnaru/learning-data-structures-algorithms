package com.abotnaru.problems.neetcode.graphs;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CourseScheduleTest {

	@Test
	void testCanFinishExpectTrue() {
		assertTrue(new CourseSchedule().canFinish(2, new int[][] { { 1, 0 } }));
	}

	@Test
	void testCanFinishMultipleExpectTrue() {
		assertTrue(new CourseSchedule().canFinish(5, new int[][] { { 0, 1 }, { 0, 2 }, { 1, 3 }, { 1, 4 }, { 3, 4 } }));
	}

	@Test
	void testCanFinishExpectFalse() {
		assertFalse(new CourseSchedule().canFinish(2, new int[][] { { 1, 0 }, { 0, 1 } }));
	}
}
