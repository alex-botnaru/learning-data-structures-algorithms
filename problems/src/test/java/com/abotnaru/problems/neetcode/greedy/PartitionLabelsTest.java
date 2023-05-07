package com.abotnaru.problems.neetcode.greedy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PartitionLabelsTest {

	@ParameterizedTest
	@MethodSource("provideParameters")
	void testPartitionLabels(String s, List<Integer> expected) {
		assertEquals(expected, new PartitionLabels().partitionLabels(s));
	}

	private static Stream<Arguments> provideParameters() {
		return Stream.of(Arguments.of("ababcbacadefegdehijhklij", List.of(9, 7, 8)),
				Arguments.of("eccbbbbdec", List.of(10)));
	}
}
