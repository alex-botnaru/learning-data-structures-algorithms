package com.abotnaru.problems.neetcode.intervals;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MergeIntervalsTest {

	@ParameterizedTest
	@MethodSource("provideParameters")
	void testMergeIntervals(int[][] intervals, int[][] expected) {
		assertArrayEquals(expected, new MergeIntervals().merge(intervals));
	}

	private static Stream<Arguments> provideParameters() {
		return Stream.of(
				Arguments.of(new int[][] { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } },
						new int[][] { { 1, 6 }, { 8, 10 }, { 15, 18 } }),
				Arguments.of(new int[][] { { 1, 3 }, { 8, 10 }, { 15, 18 }, { 2, 6 } },
						new int[][] { { 1, 6 }, { 8, 10 }, { 15, 18 } }),
				Arguments.of(new int[][] { { 1, 4 }, { 4, 5 } }, new int[][] { { 1, 5 } }),
				Arguments.of(new int[][] { { 1, 5 }, { 2, 4 } }, new int[][] { { 1, 5 } }));
	}
}
