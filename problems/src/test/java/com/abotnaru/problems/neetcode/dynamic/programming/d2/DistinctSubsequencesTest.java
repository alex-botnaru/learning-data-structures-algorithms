package com.abotnaru.problems.neetcode.dynamic.programming.d2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class DistinctSubsequencesTest {

	@ParameterizedTest
	@MethodSource("provideParameters")
	void testNumDistinct(String s, String t, int expected) {
		assertEquals(expected, new DistinctSubsequences().numDistinct(s, t));
	}

	private static Stream<Arguments> provideParameters() {
		return Stream.of(Arguments.of("rabbbit", "rabbit", 3), Arguments.of("babgbag", "bag", 5));
	}
}
