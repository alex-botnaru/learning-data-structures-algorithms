package com.abotnaru.problems.neetcode.greedy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class JumpGameIITest {

	@ParameterizedTest
	@MethodSource("provideParameters")
	void testJump(int[] nums, int expected) {
		assertEquals(expected, new JumpGameII().jump(nums));
	}

	private static Stream<Arguments> provideParameters() {
		return Stream.of(Arguments.of(new int[] { 2, 3, 1, 1, 4 }, 2), Arguments.of(new int[] { 2, 3, 0, 1, 4 }, 2));
	}
}
