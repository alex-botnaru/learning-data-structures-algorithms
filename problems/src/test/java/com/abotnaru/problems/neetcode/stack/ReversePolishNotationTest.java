package com.abotnaru.problems.neetcode.stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ReversePolishNotationTest {
	
	@ParameterizedTest
	@MethodSource("provideParameters")
	void testEvaluateReversePolishNotation(String[] input, int expected) {
		assertEquals(expected, new ReversePolishNotation().evalRPN(input));
	}

	private static Stream<Arguments> provideParameters() {
		return Stream.of(Arguments.of(new String[] {"1"}, 1),
				Arguments.of(new String[] {"2", "2", "+"}, 4),
				Arguments.of(new String[] {"2", "1", "+", "3", "*"}, 9),
				Arguments.of(new String[] {"4","13","5","/","+"}, 6),
				Arguments.of(new String[] {"10","6","9","3","+","-11","*","/","*","17","+","5","+"}, 22));
	}

}
