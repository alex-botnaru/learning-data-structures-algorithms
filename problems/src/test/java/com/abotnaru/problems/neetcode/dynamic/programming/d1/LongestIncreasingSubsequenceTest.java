package com.abotnaru.problems.neetcode.dynamic.programming.d1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LongestIncreasingSubsequenceTest {

	@ParameterizedTest
	@MethodSource("provideParameters")
	void testLongestIncreasingSequence(int[] nums, int expected) {
		assertEquals(expected, new LongestIncreasingSubsequence().lengthOfLIS(nums));
	}

	private static Stream<Arguments> provideParameters() {
		return Stream.of(Arguments.of(new int[] { 10, 9, 2, 5, 3, 7, 101, 18 }, 4),
				Arguments.of(new int[] { 0, 1, 0, 3, 2, 3 }, 4), Arguments.of(new int[] { 7, 7, 7, 7, 7, 7, 7 }, 1));
	}

}
