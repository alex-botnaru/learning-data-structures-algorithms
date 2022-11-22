package com.abotnaru.problems.neetcode.two.pointers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TwoSum2Test {

	@ParameterizedTest
	@MethodSource("provideParameters")
	void testTwoSumTwo(int[] numbers, int target, int index1, int index2) {
		int[] actual = new TwoSum2().twoSum(numbers, target);
		assertEquals(2, actual.length);
		assertEquals(index1, actual[0]);
		assertEquals(index2, actual[1]);
	}

	private static Stream<Arguments> provideParameters() {
		return Stream.of(Arguments.of(new int[] { -1, 0 }, -1, 1, 2), Arguments.of(new int[] { 2, 7, 11, 15 }, 9, 1, 2),
				Arguments.of(new int[] { 1, 2, 3, 4, 5, 6, 7, 11, 15, 30, 40 }, 70, 10, 11),
				Arguments.of(new int[] { -12, -10, 0, 7, 11, 15, 40, 45 }, 30, 2, 7),
				Arguments.of(new int[] { 2, 3, 4 }, 6, 1, 3),
				Arguments.of(new int[] { 1, 3, 4, 5, 7, 10, 11 }, 9, 3, 4),
				Arguments.of(new int[] { 2, 3, 4, 4, 8, 10 }, 8, 3, 4));
	}

}
