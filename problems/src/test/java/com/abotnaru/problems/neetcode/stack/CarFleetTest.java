package com.abotnaru.problems.neetcode.stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CarFleetTest {
	
	@ParameterizedTest
	@MethodSource("provideParameters")
	void testCarFleet(int target, int[] position, int[] speed, int expected) {
		assertEquals(expected, new CarFleet().carFleet(target, position, speed));
	}

	private static Stream<Arguments> provideParameters() {
		return Stream.of(Arguments.of(12, new int[] { 10, 8, 0, 5, 3 }, new int[] { 2, 4, 1, 1, 3 }, 3),
				Arguments.of(10, new int[] { 3 }, new int[] { 3 }, 1),
				Arguments.of(100, new int[] { 0, 2, 4 }, new int[] { 4, 2, 1 }, 1));
	}

}
