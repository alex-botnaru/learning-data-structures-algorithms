package com.abotnaru.problems.neetcode.math;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MatrixZeroesTest {

	@ParameterizedTest
	@MethodSource("provideParameters")
	void testSetZeroes(int[][] matrix, int[][] expected) {
		new MatrixZeroes().setZeroes(matrix);
		assertArrayEquals(expected, matrix);
	}

	private static Stream<Arguments> provideParameters() {
		return Stream.of(
				Arguments.of(new int[][] { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } },
						new int[][] { { 1, 0, 1 }, { 0, 0, 0 }, { 1, 0, 1 } }),
				Arguments.of(new int[][] { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } },
						new int[][] { { 0, 0, 0, 0 }, { 0, 4, 5, 0 }, { 0, 3, 1, 0 } }));
	}
}
