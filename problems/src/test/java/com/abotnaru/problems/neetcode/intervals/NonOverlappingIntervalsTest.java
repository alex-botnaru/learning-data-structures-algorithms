package com.abotnaru.problems.neetcode.intervals;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class NonOverlappingIntervalsTest {

	@ParameterizedTest
	@MethodSource("provideParameters")
	void testEraseOveralpIntervals(int[][] intervals, int expected) {
		assertEquals(expected, new NonOverlappingIntervals().eraseOverlapIntervals(intervals));
	}

	private static Stream<Arguments> provideParameters() {
		return Stream.of(Arguments.of(new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 3 } }, 1),
				Arguments.of(new int[][] { { 1, 2 }, { 1, 2 }, { 1, 2 } }, 2),
				Arguments.of(new int[][] { { 1, 2 }, { 2, 3 } }, 0));
	}
}
