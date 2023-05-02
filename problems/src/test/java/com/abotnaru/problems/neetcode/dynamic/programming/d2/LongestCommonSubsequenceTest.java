package com.abotnaru.problems.neetcode.dynamic.programming.d2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LongestCommonSubsequenceTest {

	@ParameterizedTest
	@MethodSource("provideParameters")
	void testUniquePaths(String text1, String text2, int expected) {
		assertEquals(expected, new LongestCommonSubsequence().longestCommonSubsequence(text1, text2));
	}

	private static Stream<Arguments> provideParameters() {
		return Stream.of(Arguments.of("abcde", "ace", 3), Arguments.of("abc", "abc", 3), Arguments.of("abc", "def", 0),
				Arguments.of("abcde", "acte", 3));
	}
}
