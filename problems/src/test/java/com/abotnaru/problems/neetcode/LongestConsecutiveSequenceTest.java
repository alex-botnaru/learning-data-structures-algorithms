package com.abotnaru.problems.neetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class LongestConsecutiveSequenceTest {

	@Test
	void testLongestConsecutiveSequenceOne() {
		int[] input = new int[] { 1, 4, 6, 9, 11, 6, 4, -2 };
		int actual = new LongestConsecutiveSequence().longestConsecutive(input);
		assertEquals(1, actual);
	}

	@Test
	void testLongestConsecutiveSequenceThree() {
		int[] input = new int[] { 98, 4, 97, 8, 10, 2, 96, 0 };
		int actual = new LongestConsecutiveSequence().longestConsecutive(input);
		assertEquals(3, actual);
	}

	@Test
	void testLongestConsecutiveSequenceFour() {
		int[] input = new int[] { 100, 4, 200, 1, 3, 2 };
		int actual = new LongestConsecutiveSequence().longestConsecutive(input);
		assertEquals(4, actual);
	}

	@Test
	void testLongestConsecutiveSequenceNine() {
		int[] input = new int[] { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 };
		int actual = new LongestConsecutiveSequence().longestConsecutive(input);
		assertEquals(9, actual);
	}
}
