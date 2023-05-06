package com.abotnaru.problems.neetcode.dynamic.programming.d2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RegularExpressionMatchingTest {

	@ParameterizedTest
	@MethodSource("provideParameters")
	void testIsMatch(String s, String p, boolean expected) {
		assertEquals(expected, new RegularExpressionMatching().isMatch(s, p));
	}

	private static Stream<Arguments> provideParameters() {
		return Stream.of(Arguments.of("aa", "a", false), Arguments.of("aa", "a*", true), Arguments.of("ab", ".*", true),
				Arguments.of("aa", "a..", false), Arguments.of("aab", "c*a*b", true));
	}
}
