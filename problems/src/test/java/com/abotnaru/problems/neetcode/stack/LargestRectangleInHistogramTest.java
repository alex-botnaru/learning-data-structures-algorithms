package com.abotnaru.problems.neetcode.stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LargestRectangleInHistogramTest {

	@ParameterizedTest
	@MethodSource("provideParameters")
	void testLargestRectangleArea(int[] heights, int expected) {
		assertEquals(expected, new LargestRectangleInHistogram().largestRectangleArea(heights));
	}

	private static Stream<Arguments> provideParameters() {
		return Stream.of(Arguments.of(new int[] { 0, 0 }, 0),
				Arguments.of(new int[] { 1, 0, 0 }, 1),
				Arguments.of(new int[] { 2, 1, 5, 6, 2, 3 }, 10),
				Arguments.of(new int[] { 4, 5, 6, 4 }, 16),
				Arguments.of(new int[] { 1,2,1,3,1 }, 5),
				Arguments.of(new int[] { 2,2,5,3,1 }, 8),
				Arguments.of(new int[] { 2,2,5,5,1 }, 10),
				Arguments.of(new int[] { 0, 1, 1, 2, 2, 3, 6, 7 }, 12),
				Arguments.of(new int[] {4, 4, 0, 1, 1, 1, 1, 1, 6, 1, 2, 1, 1 }, 10),
				Arguments.of(new int[] { 2, 4 }, 4));
	}
}
