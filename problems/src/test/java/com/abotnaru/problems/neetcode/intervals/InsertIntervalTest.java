package com.abotnaru.problems.neetcode.intervals;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class InsertIntervalTest {

	@ParameterizedTest
	@MethodSource("provideParameters")
	void testInsertIntervals(int[][] intervals, int[] newInterval, int[][] expected) {
		assertArrayEquals(expected, new InsertInterval().insert(intervals, newInterval));
	}

	private static Stream<Arguments> provideParameters() {
		return Stream.of(
				Arguments.of(new int[][] { { 1, 3 }, { 6, 9 } }, new int[] { 2, 5 },
						new int[][] { { 1, 5 }, { 6, 9 } }),
				Arguments.of(new int[][] { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } }, new int[] { 4, 8 },
						new int[][] { { 1, 2 }, { 3, 10 }, { 12, 16 } }),
				Arguments.of(new int[][] { { 3, 5 }, { 6, 9 } }, new int[] { 1, 2 },
						new int[][] { { 1, 2 }, { 3, 5 }, { 6, 9 } }),
				Arguments.of(new int[][] { { 3, 5 }, { 6, 9 } }, new int[] { 10, 12 },
						new int[][] { { 3, 5 }, { 6, 9 }, { 10, 12 } }));
	}

}
