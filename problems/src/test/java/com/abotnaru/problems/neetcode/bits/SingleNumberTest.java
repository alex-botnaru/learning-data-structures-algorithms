package com.abotnaru.problems.neetcode.bits;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SingleNumberTest {

	@ParameterizedTest
	@MethodSource("provideParameters")
	void testSingleNumber(int[] nums, int expected) {
		assertEquals(expected, new SingleNumber().singleNumber(nums));
	}

	private static Stream<Arguments> provideParameters() {
		return Stream.of(Arguments.of(new int[] { 2, 2, 1 }, 1), Arguments.of(new int[] { 4, 1, 2, 1, 2 }, 4),
				Arguments.of(new int[] { 1 }, 1));
	}
}
