package com.abotnaru.problems.neetcode.binary.search;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BinarySearchTest {
	@ParameterizedTest
	@MethodSource("provideParameters")
	void testBinarySearch(int[] nums, int target, int expected) {
		assertEquals(expected, new BinarySearch().search(nums, target));
	}

	private static Stream<Arguments> provideParameters() {
		return Stream.of(Arguments.of(new int[] { 0, 1, 2, 3 }, 1, 1),
				Arguments.of(new int[] { 0, 1, 2, 3 }, 4, -1),
				Arguments.of(new int[] { -1, 0, 3, 5, 9, 12 }, 9, 4),
				Arguments.of(new int[] { -1, 0, 3, 5, 9, 12 }, 2, -1));
	}
}
