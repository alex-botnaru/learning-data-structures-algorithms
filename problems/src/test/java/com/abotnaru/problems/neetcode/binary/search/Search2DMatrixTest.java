package com.abotnaru.problems.neetcode.binary.search;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Search2DMatrixTest {

	@ParameterizedTest
	@MethodSource("provideParameters")
	void testBinarySearch(int[][] matrix, int target, boolean expected) {
		assertEquals(expected, new Search2DMatrix().searchMatrix(matrix, target));
	}

	private static Stream<Arguments> provideParameters() {
		return Stream.of(Arguments.of(new int[][] { {1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60} }, 3, true),
				Arguments.of(new int[][] { {1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60} }, 13, false));
	}
}
