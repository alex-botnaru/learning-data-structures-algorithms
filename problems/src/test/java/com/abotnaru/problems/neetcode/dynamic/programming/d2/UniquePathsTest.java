package com.abotnaru.problems.neetcode.dynamic.programming.d2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class UniquePathsTest {

	@ParameterizedTest
	@MethodSource("provideParameters")
	void testUniquePaths(int m, int n, int expected) {
		assertEquals(expected, new UniquePaths().uniquePaths(m, n));
	}

	private static Stream<Arguments> provideParameters() {
		return Stream.of(Arguments.of(3, 7, 28), Arguments.of(3, 2, 3));
	}

}
