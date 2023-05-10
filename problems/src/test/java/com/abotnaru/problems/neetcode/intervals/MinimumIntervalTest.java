package com.abotnaru.problems.neetcode.intervals;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MinimumIntervalTest {

	@ParameterizedTest
	@MethodSource("provideParameters")
	void testMinInterval(int[][] intervals, int[] queries, int[] expected) {
		assertArrayEquals(expected, new MinimumInterval().minInterval(intervals, queries));
	}

	private static Stream<Arguments> provideParameters() {
		return Stream.of(
				Arguments.of(new int[][] { { 1, 4 }, { 2, 4 }, { 3, 6 }, { 4, 4 } }, new int[] { 2, 3, 4, 5 },
						new int[] { 3, 3, 1, 4 }),
				Arguments.of(new int[][] { { 2, 3 }, { 2, 5 }, { 1, 8 }, { 20, 25 } }, new int[] { 2, 19, 5, 22 },
						new int[] { 2, -1, 4, 6 }));
	}

}
