package com.abotnaru.problems.neetcode.dynamic.programming.d1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CoinChangeTest {

	@ParameterizedTest
	@MethodSource("provideParameters")
	void testCoinChange(int[] coins, int target, int expected) {
		assertEquals(expected, new CoinChange().coinChange(coins, target));
	}

	private static Stream<Arguments> provideParameters() {
		return Stream.of(Arguments.of(new int[] { 1, 2, 5 }, 11, 3), Arguments.of(new int[] { 2 }, 3, -1),
				Arguments.of(new int[] { 1 }, 0, 0));
	}
}
