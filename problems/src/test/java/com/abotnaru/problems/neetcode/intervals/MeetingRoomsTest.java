package com.abotnaru.problems.neetcode.intervals;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MeetingRoomsTest {

	@ParameterizedTest
	@MethodSource("provideParameters")
	void testCanAttendMeetings(int[][] intervals, boolean expected) {
		assertEquals(expected, new MeetingRooms().canAttendMeetings(intervals));
	}

	private static Stream<Arguments> provideParameters() {
		return Stream.of(Arguments.of(new int[][] { { 0, 30 }, { 5, 10 }, { 15, 20 } }, false),
				Arguments.of(new int[][] { { 5, 8 }, { 9, 15 } }, true));
	}

}
