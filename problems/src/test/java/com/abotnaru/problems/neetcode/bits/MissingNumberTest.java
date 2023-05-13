package com.abotnaru.problems.neetcode.bits;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MissingNumberTest {

	@ParameterizedTest
	@MethodSource("provideParameters")
	void testMissingNumber(int[] nums, int expected) {
		assertEquals(expected, new MissingNumber().missingNumber(nums));
	}

	private static Stream<Arguments> provideParameters() {
		return Stream.of(Arguments.of(new int[] { 3, 0, 1 }, 2), Arguments.of(new int[] { 0, 1 }, 2),
				Arguments.of(new int[] { 9, 6, 4, 2, 3, 5, 7, 0, 1 }, 8));
	}
}
