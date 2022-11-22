package com.abotnaru.problems.neetcode.stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ValidParenthesesTest {

	@ParameterizedTest
	@MethodSource("provideParameters")
	void testValidParetheses(String input, boolean expected) {
		assertEquals(expected, new ValidParentheses().isValid(input));
	}

	private static Stream<Arguments> provideParameters() {
		return Stream.of(Arguments.of(")", false), Arguments.of("", false), Arguments.of("(", false),
				Arguments.of(")(", false), Arguments.of("([)]", false), Arguments.of("{[", false),
				Arguments.of(")]}", false), Arguments.of("(([))", false), Arguments.of("((}))", false),
				Arguments.of("(]", false), Arguments.of("()", true), Arguments.of("[]", true), Arguments.of("{}", true),
				Arguments.of("(){}[]", true), Arguments.of("{[()]()}", true));
	}

}
