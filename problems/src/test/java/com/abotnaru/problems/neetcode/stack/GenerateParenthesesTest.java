package com.abotnaru.problems.neetcode.stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class GenerateParenthesesTest {

	@ParameterizedTest
	@MethodSource("provideParameters")
	void testEvaluateReversePolishNotation(int input, int expectedSize, String[] expectedValues) {
		List<String> expectedResult = new GenerateParentheses().generateParenthesis(input);
		assertEquals(expectedSize, expectedResult.size());
		for (String value : expectedValues) {
			assertTrue(expectedResult.contains(value));
		}
	}

	private static Stream<Arguments> provideParameters() {
		return Stream.of(Arguments.of(0, 0, new String[] {}), 
				Arguments.of(1, 1, new String[] { "()" }),
				Arguments.of(2, 2, new String[] { "(())", "()()" }),
				Arguments.of(3, 5, new String[] { "((()))", "(())()", "()(())", "(()())", "()()()" }),
				Arguments.of(4, 14, new String[] {"(((())))", "((()()))", "((())())", "()()(())", "()()()()"}), 
				Arguments.of(5, 42, new String[] {"((((()))))", "((()()))()", "(()()(()))", "()(()(()))", "()()()()()"}));
	}
}
