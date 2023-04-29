package com.abotnaru.problems.neetcode.dynamic.programming.d1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PalindromicSubstringsTest {

	@ParameterizedTest
	@MethodSource("provideParameters")
	void testHouseRobber(String input, int expected) {
		assertEquals(expected, new PalindromicSubstring().countSubstrings(input));
	}

	private static Stream<Arguments> provideParameters() {
		return Stream.of(Arguments.of("abc", 3), Arguments.of("aaa", 6), Arguments.of("aaab", 7));
	}
}
