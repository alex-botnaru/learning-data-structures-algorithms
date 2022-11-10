package com.abotnaru.problems.neetcode.sliding.window;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LongestRepeatingCharacterReplacementTest {

	@ParameterizedTest
	@MethodSource("provideParameters")
	void testCharacterReplacement(String s, int k, int expected) {
		assertEquals(expected, new LongestRepeatingCharacterReplacement().characterReplacement(s, k));
	}

	private static Stream<Arguments> provideParameters() {
		return Stream.of(Arguments.of("ABAB", 2, 4),
				Arguments.of("ABBBA", 2, 5),
				Arguments.of("BBBBB", 1, 5),
				Arguments.of("ABBBB", 2, 5),
				Arguments.of("AABBBB", 1, 5),
				Arguments.of("ABCDEFEHIJ", 1, 3),
				Arguments.of("ABCDEFGHIJ", 1, 2),
				Arguments.of("ABCDEDFDGHIJKL", 2, 5),
				Arguments.of("AABABBA", 1, 4));
	}
}
