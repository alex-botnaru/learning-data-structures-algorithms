package com.abotnaru.problems.neetcode.two.pointers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ContainerWithMostWaterTest {
	
	@ParameterizedTest
	@MethodSource("provideParameters")
	void testMaxArea(int[] height, int expectedMaxArea) {
		int actualMaxArea = new ContainerWithMostWater().maxArea(height);
		assertEquals(expectedMaxArea, actualMaxArea);
	}
	
	private static Stream<Arguments> provideParameters() {
		return Stream.of(Arguments.of(new int[] { 1 }, 0), 
				Arguments.of(new int[] { 1, 1 }, 1),
				Arguments.of(new int[] { 1, 2, 8, 7, 1 }, 7),
				Arguments.of(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }, 49),
				Arguments.of(new int[] { 1, 8, 6, 2, 10, 4, 7, 8, 2 }, 48),
				Arguments.of(new int[] { 1, 4, 3, 2, 160, 200, 4, 8, 2 }, 160), 
				Arguments.of(new int[] { 1, 9, 8, 1, 2 }, 8));
	}

}
