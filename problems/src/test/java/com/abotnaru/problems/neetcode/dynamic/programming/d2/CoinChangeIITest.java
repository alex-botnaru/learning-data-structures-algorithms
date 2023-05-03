package com.abotnaru.problems.neetcode.dynamic.programming.d2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CoinChangeIITest {

	@ParameterizedTest
	@MethodSource("provideParameters")
	void testChange(int amount, int[] coins, int expected) {
		assertEquals(expected, new CoinChangeII().change(amount, coins));
	}

	private static Stream<Arguments> provideParameters() {
		return Stream.of(Arguments.of(5, new int[] { 1, 2, 5 }, 4), Arguments.of(3, new int[] { 2 }, 0),
				Arguments.of(10, new int[] { 10 }, 1));
	}
}
