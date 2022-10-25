package com.abotnaru.problems.neetcode.sliding.window;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LongestSubstringWithoutRepeatingCharactersTest {
	
	@ParameterizedTest
	@MethodSource("provideParameters")
	void testMaxProfits(String string, int expectedLongestSubstring) {
		int actualLongestSubstring = new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(string);
		assertEquals(expectedLongestSubstring, actualLongestSubstring);
	}
	
	private static Stream<Arguments> provideParameters() {
		return Stream.of(Arguments.of("abcabcbb", 3),
				Arguments.of("bbbbb", 1),
				Arguments.of("pwwkew", 3),
				Arguments.of("wolf", 4),
				Arguments.of("alhambra", 6));
	}

}
