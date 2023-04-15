package com.abotnaru.problems.neetcode.advanced.graphs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class AlienDictionaryTest {

	@Test
	void testAlienOrderExpectWertf() {
		assertEquals("wertf", new AlienDictionary().alienOrder(new String[] { "wrt", "wrf", "er", "ett", "rftt" }));
	}

	@Test
	void testAlienOrderExpectXz() {
		assertEquals("zx", new AlienDictionary().alienOrder(new String[] { "z", "x" }));
	}

	@Test
	void testAlienOrderExpectInvalid() {
		assertEquals("", new AlienDictionary().alienOrder(new String[] { "wrt", "wrf", "ert", "er", "ett", "rftt" }));
	}

	@Test
	void testAlienOrderExpectInvalidCycle() {
		assertEquals("", new AlienDictionary().alienOrder(new String[] { "we", "ee", "we" }));
	}

}
