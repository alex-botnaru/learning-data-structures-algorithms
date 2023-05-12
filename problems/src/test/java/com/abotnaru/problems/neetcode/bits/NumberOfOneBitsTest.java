package com.abotnaru.problems.neetcode.bits;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class NumberOfOneBitsTest {

	@ParameterizedTest
	@MethodSource("provideParameters")
	void testHammingWeight(int n, int expected) {
		assertEquals(expected, new NumberOfOneBits().hammingWeight(n));
	}

	private static Stream<Arguments> provideParameters() {
		return Stream.of(Arguments.of(0b00000000000000000000000000001011, 3),
				Arguments.of(0b00000000000000000000000010000000, 1),
				Arguments.of(0b11111111111111111111111111111101, 31));
	}
}
