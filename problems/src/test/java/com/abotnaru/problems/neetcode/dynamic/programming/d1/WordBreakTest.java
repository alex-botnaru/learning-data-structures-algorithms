package com.abotnaru.problems.neetcode.dynamic.programming.d1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WordBreakTest {

	@ParameterizedTest
	@MethodSource("provideParameters")
	void testWordBreak(String s, List<String> wordDict, boolean expected) {
		assertEquals(expected, new WordBreak().wordBreak(s, wordDict));
	}

	private static Stream<Arguments> provideParameters() {
		return Stream.of(Arguments.of("leetcode", List.of("leet", "code"), true),
				Arguments.of("applepenapple", List.of("apple", "pen"), true),
				Arguments.of("catsandog", List.of("cats", "dog", "sand", "and", "cat"), false));
	}
}
