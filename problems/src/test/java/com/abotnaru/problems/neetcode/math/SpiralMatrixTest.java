package com.abotnaru.problems.neetcode.math;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SpiralMatrixTest {

	@ParameterizedTest
	@MethodSource("provideParameters")
	void testSpiralOrder(int[][] matrix, List<Integer> expected) {
		assertEquals(expected, new SpiralMatrix().spiralOrder(matrix));
	}

	private static Stream<Arguments> provideParameters() {
		return Stream.of(
				Arguments.of(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }, List.of(1, 2, 3, 6, 9, 8, 7, 4, 5)),
				Arguments.of(new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } },
						List.of(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7)),
				Arguments.of(new int[][] { { 1, 2, 3} }, List.of(1, 2, 3)));
	}
}
