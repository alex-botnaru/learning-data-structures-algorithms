package com.abotnaru.problems.neetcode.dynamic.programming.d2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TargetSumTest {

	@ParameterizedTest
	@MethodSource("provideParameters")
	void testFindTargetSumWay(int[] nums, int target, int expected) {
		assertEquals(expected, new TargetSum().findTargetSumWays(nums, target));
	}

	private static Stream<Arguments> provideParameters() {
		return Stream.of(Arguments.of(new int[] { 1, 1, 1, 1, 1 }, 3, 5), Arguments.of(new int[] { 1 }, 1, 1));
	}
}
