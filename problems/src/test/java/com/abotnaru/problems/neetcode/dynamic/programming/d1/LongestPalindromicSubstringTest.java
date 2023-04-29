package com.abotnaru.problems.neetcode.dynamic.programming.d1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LongestPalindromicSubstringTest {

	@ParameterizedTest
	@MethodSource("provideParameters")
	void testLongestPalindromicSubstring(String input, String expected) {
		assertEquals(expected, new LongestPalindromicSubstring().longestPalindrome(input));
	}

	private static Stream<Arguments> provideParameters() {
		return Stream.of(Arguments.of("babad", "bab"), Arguments.of("cbbd", "bb"));
	}
}
