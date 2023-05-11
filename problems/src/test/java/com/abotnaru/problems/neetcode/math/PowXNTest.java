package com.abotnaru.problems.neetcode.math;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PowXNTest {

	@ParameterizedTest
	@MethodSource("provideParameters")
	void testMyPow(double x, int n, double expected) {
		assertEquals(expected, new PowXN().myPow(x, n), 0.0000000001);
	}

	private static Stream<Arguments> provideParameters() {
		return Stream.of(Arguments.of(2, 10, 1024), Arguments.of(2.1, 3, 9.261), Arguments.of(2, -2, .25),
				Arguments.of(2, 0, 1));
	}
}
