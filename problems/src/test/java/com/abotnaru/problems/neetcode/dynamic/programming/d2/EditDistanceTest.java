package com.abotnaru.problems.neetcode.dynamic.programming.d2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class EditDistanceTest {

	@ParameterizedTest
	@MethodSource("provideParameters")
	void testMinDistance(String word1, String word2, int expected) {
		assertEquals(expected, new EditDistance().minDistance(word1, word2));
	}

	private static Stream<Arguments> provideParameters() {
		return Stream.of(Arguments.of("horse", "ros", 3), Arguments.of("intention", "execution", 5));
	}
}
