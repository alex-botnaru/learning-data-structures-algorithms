package com.abotnaru.problems.neetcode.dynamic.programming.d1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MaximumProductSubarrayTest {

	@ParameterizedTest
	@MethodSource("provideParameters")
	void testMaxProductSubarray(int[] nums, int expected) {
		assertEquals(expected, new MaximumProductSubarray().maxProduct(nums));
	}

	private static Stream<Arguments> provideParameters() {
		return Stream.of(Arguments.of(new int[] { 2, 3, -2, 4 }, 6), Arguments.of(new int[] { -2, 0, -1 }, 0),
				Arguments.of(new int[] { -1, -2, -3, -4 }, 24));
	}

}
