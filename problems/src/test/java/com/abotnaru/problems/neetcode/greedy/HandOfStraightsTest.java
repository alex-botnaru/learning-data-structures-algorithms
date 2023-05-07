package com.abotnaru.problems.neetcode.greedy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class HandOfStraightsTest {

	@ParameterizedTest
	@MethodSource("provideParameters")
	void testisNStraightHand(int[] hand, int groupSize, boolean expected) {
		assertEquals(expected, new HandOfStraights().isNStraightHand(hand, groupSize));
	}

	private static Stream<Arguments> provideParameters() {
		return Stream.of(Arguments.of(new int[] { 1, 2, 3, 6, 2, 3, 4, 7, 8 }, 3, true),
				Arguments.of(new int[] { 1, 2, 3, 4, 5 }, 4, false));
	}
}
