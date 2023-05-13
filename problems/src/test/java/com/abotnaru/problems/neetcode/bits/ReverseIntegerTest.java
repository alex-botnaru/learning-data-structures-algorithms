package com.abotnaru.problems.neetcode.bits;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ReverseIntegerTest {

	@ParameterizedTest
	@MethodSource("provideParameters")
	void testReverse(int x, int expected) {
		assertEquals(expected, new ReverseInteger().reverse(x));
	}

	private static Stream<Arguments> provideParameters() {
		return Stream.of(Arguments.of(123, 321), Arguments.of(-123, -321), Arguments.of(120, 21),
				Arguments.of(Integer.MAX_VALUE, 0));
	}
}
