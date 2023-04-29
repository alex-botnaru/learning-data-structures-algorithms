package com.abotnaru.problems.neetcode.dynamic.programming.d1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class DecodeWaysTest {

	@ParameterizedTest
	@MethodSource("provideParameters")
	void testNumDecodings(String input, int expected) {
		assertEquals(expected, new DecodeWays().numDecodings(input));
	}

	@ParameterizedTest
	@MethodSource("provideParameters")
	void testNumDecodingsWithArrays(String input, int expected) {
		assertEquals(expected, new DecodeWays().numDecodingsWithArray(input));
	}

	private static Stream<Arguments> provideParameters() {
		return Stream.of(Arguments.of("12", 2), Arguments.of("226", 3), Arguments.of("06", 0), Arguments.of("1006", 0), Arguments.of("1", 1), Arguments.of("", 0));
	}

}
