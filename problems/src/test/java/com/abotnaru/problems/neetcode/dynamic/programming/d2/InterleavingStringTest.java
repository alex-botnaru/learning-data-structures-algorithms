package com.abotnaru.problems.neetcode.dynamic.programming.d2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class InterleavingStringTest {
	@ParameterizedTest
	@MethodSource("provideParameters")
	void testisInterleave(String s1, String s2, String s3, boolean expected) {
		assertEquals(expected, new InterleavingString().isInterleave(s1, s2, s3));
	}

	private static Stream<Arguments> provideParameters() {
		return Stream.of(Arguments.of("aabcc", "dbbca", "aadbbcbcac", true),
				Arguments.of("aabcc", "dbbca", "aadbbbaccc", false), Arguments.of("", "", "", true));
	}
}
