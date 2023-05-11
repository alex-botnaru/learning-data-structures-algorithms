package com.abotnaru.problems.neetcode.math;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PlusOneTest {

	@ParameterizedTest
	@MethodSource("provideParameters")
	void testPlusOne(int[] digits, int[] expected) {
		assertArrayEquals(expected, new PlusOne().plusOne(digits));
	}

	private static Stream<Arguments> provideParameters() {
		return Stream.of(Arguments.of(new int[] { 1, 2, 3 }, new int[] { 1, 2, 4 }),
				Arguments.of(new int[] { 1, 2, 9 }, new int[] { 1, 3, 0 }),
				Arguments.of(new int[] { 9, 9 }, new int[] { 1, 0, 0 }),
				Arguments.of(new int[] { 4, 3, 2, 1 }, new int[] { 4, 3, 2, 2 }));
	}
}
