package com.abotnaru.problems.neetcode.dynamic.programming.d2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BurstBalloonsTest {

	@ParameterizedTest
	@MethodSource("provideParameters")
	void testMaxCoins(int[] nums, int expected) {
		assertEquals(expected, new BurstBalloons().maxCoins(nums));
	}

	private static Stream<Arguments> provideParameters() {
		return Stream.of(Arguments.of(new int[] { 3, 1, 5, 8 }, 167), Arguments.of(new int[] { 1, 5 }, 10));
	}
}
