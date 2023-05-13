package com.abotnaru.problems.neetcode.bits;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CountingBitsTest {

	@ParameterizedTest
	@MethodSource("provideParameters")
	void testCountBits(int n, int[] expected) {
		assertArrayEquals(expected, new CountingBits().countBits(n));
	}

	private static Stream<Arguments> provideParameters() {
		return Stream.of(Arguments.of(2, new int[] { 0, 1, 1 }), Arguments.of(5, new int[] { 0, 1, 1, 2, 1, 2 }),
				Arguments.of(8, new int[] { 0, 1, 1, 2, 1, 2, 2, 3, 1 }));
	}
}
