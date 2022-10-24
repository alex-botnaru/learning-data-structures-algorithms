package com.abotnaru.problems.neetcode.sliding.window;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BestTimeBuySellStockTest {

	@ParameterizedTest
	@MethodSource("provideParameters")
	void testFirstArray(int[] prices, int expectedMaxProfit) {
		int actualMaxProfit = new BestTimeBuySellStock().maxProfit(prices);
		assertEquals(expectedMaxProfit, actualMaxProfit);
	}
	
	private static Stream<Arguments> provideParameters() {
		return Stream.of(Arguments.of(new int[] { 4 }, 0),
				Arguments.of(new int[] { 4, 1 }, 0),
				Arguments.of(new int[] { 1, 4 }, 3),
				Arguments.of(new int[] { 4, 2, 6, 5, 1, 6, 3 }, 5),
				Arguments.of(new int[] { 4, 2, 3, 4, 5, 6, 5, 1, 2, 3, 4, 5, 7, 3 }, 6),
				Arguments.of(new int[] { 7, 1, 5, 3, 6, 4 }, 5), 
				Arguments.of(new int[] { 7, 6, 4, 3, 1 }, 0));
	}
}
