package com.abotnaru.problems.neetcode.greedy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MaximumSubarrayTest {

	@ParameterizedTest
	@MethodSource("provideParameters")
	void testMaxSubarray(int[] nums, int expected) {
		assertEquals(expected, new MaximumSubarray().maxSubArray(nums));
	}

	private static Stream<Arguments> provideParameters() {
		return Stream.of(Arguments.of(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }, 6), Arguments.of(new int[] { 1 }, 1),
				Arguments.of(new int[] { 5, 4, -1, 7, 8 }, 23), Arguments.of(new int[] { -5, -4, -1, -7 }, -1));
	}
}
