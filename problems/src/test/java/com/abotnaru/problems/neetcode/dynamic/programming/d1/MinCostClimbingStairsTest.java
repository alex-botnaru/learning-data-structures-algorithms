package com.abotnaru.problems.neetcode.dynamic.programming.d1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MinCostClimbingStairsTest {

	@ParameterizedTest
	@MethodSource("provideParameters")
	void testMinCostClimbingStairs(int[] cost, int expected) {
		assertEquals(expected, new MinCostClimbingStairs().minCostClimbingStairs(cost));
	}

	private static Stream<Arguments> provideParameters() {
		return Stream.of(Arguments.of(new int[] { 10, 15, 20 }, 15),
				Arguments.of(new int[] { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 }, 6));
	}
}
