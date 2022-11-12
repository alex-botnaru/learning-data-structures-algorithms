package com.abotnaru.problems.neetcode.sliding.window;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MinimumWindowSubstringTest {
	
	@ParameterizedTest
	@MethodSource("provideParameters")
	void testMinWindow(String s, String t, String expected) {
		assertEquals(expected, new MinimumWindowSubstring().minWindow(s, t));
	}

	private static Stream<Arguments> provideParameters() {
		return Stream.of(Arguments.of("ADOBECODEBANC", "ABC", "BANC"),
				Arguments.of("a", "a", "a"),
				Arguments.of("aaaa", "aa", "aa"),
				Arguments.of("aadebaaecr", "ab", "ba"),
				Arguments.of("a", "aa", ""));
	}

}
