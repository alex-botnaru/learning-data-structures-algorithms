package com.abotnaru.problems.neetcode.binary.search;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MedianTwoSortedArraysTest {
	@ParameterizedTest
	@MethodSource("provideParameters")
	void testFindMedianSortedArrays(int[] nums1, int[] nums2, double expected) {
		assertEquals(expected, new MedianTwoSortedArrays().findMedianSortedArrays(nums1, nums2));
	}

	private static Stream<Arguments> provideParameters() {
		return Stream.of(Arguments.of(new int[] {1, 3 }, new int[] {2}, 2.00),
				Arguments.of(new int[] {1, 2 }, new int[] {3, 4}, 2.50),
				Arguments.of(new int[] {2, 3 }, new int[] {1, 4}, 2.50),
				Arguments.of(new int[] {1, 3 }, new int[] {2, 4}, 2.50),
				Arguments.of(new int[] {1, 3, 5 }, new int[] {2, 4}, 3.00),
				Arguments.of(new int[] {100, 300, 500 }, new int[] {120, 140, 200, 250, 350, 370}, 250.00),
				Arguments.of(new int[] {120, 140, 200, 250, 350, 370}, new int[] {100, 300, 500 }, 250.00));
	}
}
