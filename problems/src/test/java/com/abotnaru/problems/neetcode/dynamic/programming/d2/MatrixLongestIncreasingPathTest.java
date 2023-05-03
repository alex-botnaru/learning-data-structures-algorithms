package com.abotnaru.problems.neetcode.dynamic.programming.d2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MatrixLongestIncreasingPathTest {

	@ParameterizedTest
	@MethodSource("provideParameters")
	void testLongestIncreasingPath(int[][] matrix, int expected) {
		assertEquals(expected, new MatrixLongestIncreasingPath().longestIncreasingPath(matrix));
	}

	private static Stream<Arguments> provideParameters() {
		return Stream.of(Arguments.of(new int[][] { { 9, 9, 4 }, { 6, 6, 8 }, { 2, 1, 1 } }, 4),
				Arguments.of(new int[][] { { 3, 4, 5 }, { 3, 2, 6 }, { 2, 2, 1 } }, 4),
				Arguments.of(new int[][] { { 9, 8, 7 }, { 4, 5, 6 }, { 3, 2, 1 } }, 9),
				Arguments.of(new int[][] { { 1 } }, 1));
	}
}
