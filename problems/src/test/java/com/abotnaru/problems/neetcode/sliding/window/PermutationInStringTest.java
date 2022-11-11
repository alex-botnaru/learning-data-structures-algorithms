package com.abotnaru.problems.neetcode.sliding.window;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PermutationInStringTest {

	@ParameterizedTest
	@MethodSource("provideParameters")
	void testCheckInclusion(String s1, String s2, boolean expected) {
		assertEquals(expected, new PermutationInString().checkInclusion(s1, s2));
	}

	private static Stream<Arguments> provideParameters() {
		return Stream.of(Arguments.of("ab", "eidbaooo", true),
				Arguments.of("abc", "fgjkcabrstw", true),
				Arguments.of("ded", "abbdefdop", false),
				Arguments.of("redato", "dat", false),
				Arguments.of("ab", "eidboaoo", false));
	}
}
