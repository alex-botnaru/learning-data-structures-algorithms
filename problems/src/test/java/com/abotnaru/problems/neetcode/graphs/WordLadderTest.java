package com.abotnaru.problems.neetcode.graphs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

class WordLadderTest {

	@Test
	void testWordLadderExpectFive() {
		assertEquals(5, new WordLadder().ladderLength("hit", "cog", List.of("hot", "dot", "dog", "lot", "log", "cog")));
	}

	@Test
	void testWordLadderExpectZero() {
		assertEquals(0, new WordLadder().ladderLength("hit", "cog", List.of("hot", "dot", "dog", "lot", "log")));
	}
}
