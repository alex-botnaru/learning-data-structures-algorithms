package com.abotnaru.problems.neetcode.bits;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ReverseBitsTest {

	@ParameterizedTest
	@MethodSource("provideParameters")
	void testReverseBits(int n, int expected) {
		assertEquals(expected, new ReverseBits().reverseBits(n));
	}

	private static Stream<Arguments> provideParameters() {
		return Stream.of(Arguments.of(0b00000010100101000001111010011100, 0b00111001011110000010100101000000),
				Arguments.of(0b11111111111111111111111111111101, 0b10111111111111111111111111111111));
	}

}
