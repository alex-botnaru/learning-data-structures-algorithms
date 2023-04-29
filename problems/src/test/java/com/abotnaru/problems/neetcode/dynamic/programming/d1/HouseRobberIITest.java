package com.abotnaru.problems.neetcode.dynamic.programming.d1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class HouseRobberIITest {

	@ParameterizedTest
	@MethodSource("provideParameters")
	void testHouseRobber(int[] nums, int expected) {
		assertEquals(expected, new HouseRobberII().rob(nums));
	}

	private static Stream<Arguments> provideParameters() {
		return Stream.of(Arguments.of(new int[] { 2, 3, 2 }, 3), Arguments.of(new int[] { 1, 2, 3, 1 }, 4),
				Arguments.of(new int[] { 1, 2, 3 }, 3), Arguments.of(null, 0), Arguments.of(new int[] { 9 }, 9),
				Arguments.of(new int[] { 2, 7 }, 7));
	}
}
