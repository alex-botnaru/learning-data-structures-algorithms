package com.abotnaru.problems.neetcode.dynamic.programming.d2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BestTimeBuySellStocksCooldownTest {

	@ParameterizedTest
	@MethodSource("provideParameters")
	void testMaxProfit(int[] prices, int expected) {
		assertEquals(expected, new BestTimeBuySellStocksCooldown().maxProfit(prices));
	}

	private static Stream<Arguments> provideParameters() {
		return Stream.of(Arguments.of(new int[] { 1, 2, 3, 0, 2 }, 3), Arguments.of(new int[] { 1 }, 0));
	}
}
