package com.abotnaru.problems.neetcode.math;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class HappyNumberTest {

	@ParameterizedTest
	@MethodSource("provideParameters")
	void testIsHappy(int n, boolean expected) {
		assertEquals(expected, new HappyNumber().isHappy(n));
	}

	private static Stream<Arguments> provideParameters() {
		return Stream.of(Arguments.of(19, true), Arguments.of(2, false));
	}
}
