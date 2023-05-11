package com.abotnaru.problems.neetcode.math;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MultiplyStringsTest {

	@ParameterizedTest
	@MethodSource("provideParameters")
	void testMultiply(String num1, String num2, String expected) {
		assertEquals(expected, new MultiplyStrings().multiply(num1, num2));
	}

	private static Stream<Arguments> provideParameters() {
		return Stream.of(Arguments.of("2", "3", "6"), Arguments.of("123", "456", "56088"), Arguments.of("99", "99", "9801"));
	}
}
