package com.abotnaru.problems.neetcode.greedy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class JumpGameTest {

	@ParameterizedTest
	@MethodSource("provideParameters")
	void testCanJump(int[] nums, boolean expected) {
		assertEquals(expected, new JumpGame().canJump(nums));
	}

	private static Stream<Arguments> provideParameters() {
		return Stream.of(Arguments.of(new int[] { 2, 3, 1, 1, 4 }, true),
				Arguments.of(new int[] { 3, 2, 1, 0, 4 }, false));
	}
}
