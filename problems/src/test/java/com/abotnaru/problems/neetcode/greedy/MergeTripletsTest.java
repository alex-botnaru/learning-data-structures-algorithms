package com.abotnaru.problems.neetcode.greedy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MergeTripletsTest {

	@ParameterizedTest
	@MethodSource("provideParameters")
	void testMergeTriplets(int[][] triplets, int[] target, boolean expected) {
		assertEquals(expected, new MergeTriplets().mergeTriplets(triplets, target));
	}

	private static Stream<Arguments> provideParameters() {
		return Stream.of(
				Arguments.of(new int[][] { { 2, 5, 3 }, { 1, 8, 4 }, { 1, 7, 5 } }, new int[] { 2, 7, 5 }, true),
				Arguments.of(new int[][] { { 3, 4, 5 }, { 4, 5, 6 } }, new int[] { 3, 2, 5 }, false),
				Arguments.of(new int[][] { { 2, 5, 3 }, { 2, 3, 4 }, { 1, 2, 5 }, { 5, 2, 3 } }, new int[] { 5, 5, 5 },
						true));
	}
}
