package com.abotnaru.problems.neetcode.greedy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ValidParenthesisStringTest {

	@ParameterizedTest
	@MethodSource("provideParameters")
	void testCheckValidString(String s, boolean expected) {
		assertEquals(expected, new ValidParenthesisString().checkValidString(s));
	}

	private static Stream<Arguments> provideParameters() {
		return Stream.of(Arguments.of("()", true), Arguments.of("(*)", true), Arguments.of("(*))", true),
				Arguments.of("(()", false), Arguments.of("(*)(", false));
	}
}
