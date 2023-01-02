package com.abotnaru.problems.neetcode.binary.search;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class KokoEatingBananasTest {
	
	@ParameterizedTest
	@MethodSource("provideParameters")
	void testMinEatingSpeed(int[] piles, int hours, int expected) {
		assertEquals(expected, new KokoEatingBananas().minEatingSpeed(piles, hours));
	}

	private static Stream<Arguments> provideParameters() {
		return Stream.of(Arguments.of(new int[] {3, 6, 7, 11 }, 8, 4),
				Arguments.of(new int[] {30, 11, 23, 4, 20 }, 5, 30),
				Arguments.of(new int[] {30, 11, 23, 4, 20 }, 6, 23));
	}

}
