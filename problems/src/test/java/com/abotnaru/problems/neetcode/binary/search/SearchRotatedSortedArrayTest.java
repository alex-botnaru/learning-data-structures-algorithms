package com.abotnaru.problems.neetcode.binary.search;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SearchRotatedSortedArrayTest {
	
	@ParameterizedTest
	@MethodSource("provideParameters")
	void testSearch(int[] input, int target, int expected) {
		assertEquals(expected, new SearchRotatedSortedArray().search(input, target));
	}

	private static Stream<Arguments> provideParameters() {
		return Stream.of(Arguments.of(new int[] {4, 5, 6, 7, 0, 1, 2 }, 0, 4),
				Arguments.of(new int[] {4, 5, 6, 7, 0, 1, 2 }, 3, -1),
				Arguments.of(new int[] { 1 }, 0, -1),
				Arguments.of(new int[] {1, 2, 3, 4, 5 }, 1, 0),
				Arguments.of(new int[] {5, 1, 2, 3, 4 }, 1, 1),
				Arguments.of(new int[] {5, 4, 1, 2, 3 }, 1, 2),
				Arguments.of(new int[] {3, 4, 5, 1, 2 }, 1, 3),
				Arguments.of(new int[] {2, 3, 4, 5, 1 }, 1, 4));
	}
}
