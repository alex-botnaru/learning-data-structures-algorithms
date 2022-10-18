package com.abotnaru.problems.neetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ThreeSumTest {

	@ParameterizedTest
	@MethodSource("provideParameters")
	void testThreeSum(int[] numbers, int totalTriples) {
		List<List<Integer>> actual = new ThreeSum().threeSum(numbers);
		assertEquals(totalTriples, actual.size());
	}

	private static Stream<Arguments> provideParameters() {
		return Stream.of(Arguments.of(new int[] { -1 }, 0), 
				Arguments.of(new int[] { 0, 1 }, 0),
				Arguments.of(new int[] { 0, 1, 1 }, 0),
				Arguments.of(new int[] { 0, 0, 0 }, 1),
				Arguments.of(new int[] { -1, 0, 1, 2, -1, -4 }, 2), 
				Arguments.of(new int[] { -3, 3, 4, -3, 1, 2 }, 1));
	}
}
