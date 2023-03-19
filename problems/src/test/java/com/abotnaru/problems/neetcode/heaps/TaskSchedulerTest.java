package com.abotnaru.problems.neetcode.heaps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TaskSchedulerTest {

	@Test
	void testLeastIntervalExpectEight() {
		assertEquals(8, new TaskScheduler().leastInterval(new char[] { 'A', 'A', 'A', 'B', 'B', 'B' }, 2));
	}

	@Test
	void testLeastIntervalExpectSix() {
		assertEquals(6, new TaskScheduler().leastInterval(new char[] { 'A', 'A', 'A', 'B', 'B', 'B' }, 0));
	}

	@Test
	void testLeastIntervalExpectSixteen() {
		assertEquals(16, new TaskScheduler()
				.leastInterval(new char[] { 'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G' }, 2));
	}

}
