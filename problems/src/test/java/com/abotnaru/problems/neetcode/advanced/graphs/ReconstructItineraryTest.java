package com.abotnaru.problems.neetcode.advanced.graphs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;

class ReconstructItineraryTest {

	@Test
	void testFindItinieraryFiveNodes() {
		List<String> result = new ReconstructItinerary().findItinerary(
				List.of(List.of("MUC", "LHR"), List.of("JFK", "MUC"), List.of("SFO", "SJC"), List.of("LHR", "SFO")));
		assertNotNull(result);
		assertEquals(5, result.size());
		assertEquals("JFK", result.get(0));
		assertEquals("MUC", result.get(1));
		assertEquals("LHR", result.get(2));
		assertEquals("SFO", result.get(3));
		assertEquals("SJC", result.get(4));
	}

	@Test
	void testFindItinieraryThreeNodes() {
		List<String> result = new ReconstructItinerary().findItinerary(List.of(List.of("JFK", "SFO"),
				List.of("JFK", "ATL"), List.of("SFO", "ATL"), List.of("ATL", "JFK"), List.of("ATL", "SFO")));
		assertNotNull(result);
		assertEquals(6, result.size());
		assertEquals("JFK", result.get(0));
		assertEquals("ATL", result.get(1));
		assertEquals("JFK", result.get(2));
		assertEquals("SFO", result.get(3));
		assertEquals("ATL", result.get(4));
		assertEquals("SFO", result.get(5));
	}

	@Test
	void testFindItinieraryThreeNodesTest() {
		List<String> result = new ReconstructItinerary()
				.findItinerary(List.of(List.of("JFK", "SFO"), List.of("JFK", "ATL"), List.of("SFO", "JFK")));
		assertNotNull(result);
		assertEquals(4, result.size());
		assertEquals("JFK", result.get(0));
		assertEquals("SFO", result.get(1));
		assertEquals("JFK", result.get(2));
		assertEquals("ATL", result.get(3));
	}

}
