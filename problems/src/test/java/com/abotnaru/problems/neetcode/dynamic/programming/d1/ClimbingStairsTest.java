package com.abotnaru.problems.neetcode.dynamic.programming.d1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ClimbingStairsTest {

	@ParameterizedTest
	@MethodSource("provideParameters")
	void testClimbStairs(int param, int expected) {
		assertEquals(expected, new ClimbingStairs().climbStairs(param));
	}

	@ParameterizedTest
	@MethodSource("provideParameters")
	void testClimbStairsBottomUp(int param, int expected) {
		assertEquals(expected, new ClimbingStairs().climbStairsBottomUp(param));
	}

	@ParameterizedTest
	@MethodSource("provideParameters")
	void testClimbStairsMemoization(int param, int expected) {
		assertEquals(expected, new ClimbingStairs().climbStairsMemo(param));
	}

	private static Stream<Arguments> provideParameters() {
		return Stream.of(Arguments.of(2, 2), Arguments.of(3, 3), Arguments.of(5, 8));
	}
}
