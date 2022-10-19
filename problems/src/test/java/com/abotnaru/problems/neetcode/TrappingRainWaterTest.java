package com.abotnaru.problems.neetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TrappingRainWaterTest {

	@ParameterizedTest
	@MethodSource("provideParameters")
	void testTrap(int[] height, int expectedVolume) {
		int actualVolume = new TrappingRainWater().trap(height);
		assertEquals(expectedVolume, actualVolume);
	}

	private static Stream<Arguments> provideParameters() {
		return Stream.of(Arguments.of(new int[] { 1 }, 0),
				Arguments.of(new int[] { 1, 1 }, 0),
				Arguments.of(new int[] { 0, 1, 0, 0, 0 }, 0),
				Arguments.of(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }, 6),
				Arguments.of(new int[] { 4, 2, 0, 3, 2, 5 }, 9));
	}
}
