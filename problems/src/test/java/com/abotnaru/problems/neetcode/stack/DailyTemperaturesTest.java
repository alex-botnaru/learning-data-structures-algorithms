package com.abotnaru.problems.neetcode.stack;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class DailyTemperaturesTest {

	@ParameterizedTest
	@MethodSource("provideParameters")
	void testDailyTemperatures(int[] input, int[] expectedOutput) {
		int[] actualOutput = new DailyTemperatures().dailyTemperatures(input);
		assertEquals(expectedOutput.length, actualOutput.length);
		assertArrayEquals(expectedOutput, actualOutput);
	}

	private static Stream<Arguments> provideParameters() {
		return Stream.of(Arguments.of(new int[] { 71 }, new int[] { 0 }),
				Arguments.of(new int[] { 43, 45 }, new int[] { 1, 0 }),
				Arguments.of(new int[] { 45, 43 }, new int[] { 0, 0 }),
				Arguments.of(new int[] { 73, 74, 75, 71, 69, 72, 76, 73 }, new int[] { 1, 1, 4, 2, 1, 1, 0, 0 }),
				Arguments.of(new int[] { 30, 40, 50, 60 }, new int[] { 1, 1, 1, 0 }),
				Arguments.of(new int[] { 30, 60, 90 }, new int[] { 1, 1, 0 }));
	}
}
