package com.abotnaru.problems.neetcode.dynamic.programming.d1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PartitionEqualSubsetSumTest {

	@ParameterizedTest
	@MethodSource("provideParameters")
	void testCanPartition(int[] nums, boolean expected) {
		assertEquals(expected, new PartitionEqualSubsetSum().canPartition(nums));
	}

	private static Stream<Arguments> provideParameters() {
		return Stream.of(Arguments.of(new int[] { 1, 5, 11, 5 }, true), Arguments.of(new int[] { 1, 2, 3, 5 }, false));
	}

}
