package com.abotnaru.problems.neetcode.bits;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SumTwoIntegersTest {

	@ParameterizedTest
	@MethodSource("provideParameters")
	void testGetSum(int a, int b, int expected) {
		assertEquals(expected, new SumTwoIntegers().getSum(a, b));
	}

	private static Stream<Arguments> provideParameters() {
		return Stream.of(Arguments.of(1, 2, 3), Arguments.of(2, 3, 5), Arguments.of(5, -1, 4));
	}
}
