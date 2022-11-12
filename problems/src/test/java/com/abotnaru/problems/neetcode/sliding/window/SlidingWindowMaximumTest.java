package com.abotnaru.problems.neetcode.sliding.window;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SlidingWindowMaximumTest {

	@ParameterizedTest
	@MethodSource("provideParameters")
	void testMaxSlidingWindow(int[] nums, int k, int[] expected) {
		int[] actual = new SlidingWindowMaximum().maxSlidingWindow(nums, k);
		assertEquals(expected.length, actual.length);
		for (int i = 0; i < expected.length; i++) {
			assertEquals(expected[i], actual[i]);
		}
	}

	@ParameterizedTest
	@MethodSource("provideParameters")
	void testMaxSlidingWindowWithPriorityQueue(int[] nums, int k, int[] expected) {
		int[] actual = new SlidingWindowMaximum().maxSlidingWindowPriorityQueue(nums, k);
		assertEquals(expected.length, actual.length);
		for (int i = 0; i < expected.length; i++) {
			assertEquals(expected[i], actual[i]);
		}
	}

	private static Stream<Arguments> provideParameters() {
		return Stream.of(Arguments.of(new int[] { 1 }, 1, new int[] { 1 }),
				Arguments.of(new int[] { 1, 3, -1 }, 3, new int[] { 3 }),
				Arguments.of(new int[] { 1, 2, 3, 4 }, 3, new int[] { 3, 4 }),
				Arguments.of(new int[] { 8, 7, 6, 9 }, 2, new int[] { 8, 7, 9 }),
				Arguments.of(new int[] { 1, 1, 1, 1, 1, 4, 5 }, 6, new int[] { 4, 5 }),
				Arguments.of(new int[] { 1, 3, -1, -3, 1, -1, 1, -2, 1, 5, 3, 6, 7 }, 3,
						new int[] { 3, 3, 1, 1, 1, 1, 1, 5, 5, 6, 7 }),
				Arguments.of(new int[] { 1, 3, -1, -3, 5, 3, 6, 7 }, 3, new int[] { 3, 3, 5, 5, 6, 7 }));
	}
}
