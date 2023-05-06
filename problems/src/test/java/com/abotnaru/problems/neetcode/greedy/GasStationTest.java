package com.abotnaru.problems.neetcode.greedy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class GasStationTest {

	@ParameterizedTest
	@MethodSource("provideParameters")
	void testCanCompleteCircuit(int[] gas, int[] cost, int expected) {
		assertEquals(expected, new GasStation().canCompleteCircuit(gas, cost));
	}

	private static Stream<Arguments> provideParameters() {
		return Stream.of(Arguments.of(new int[] { 1, 2, 3, 4, 5 }, new int[] { 3, 4, 5, 1, 2 }, 3),
				Arguments.of(new int[] { 2, 3, 4 }, new int[] { 3, 4, 3 }, -1));
	}
}
