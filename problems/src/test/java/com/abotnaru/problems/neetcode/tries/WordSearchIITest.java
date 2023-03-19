package com.abotnaru.problems.neetcode.tries;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

class WordSearchIITest {

	@Test
	void testFindWordsExpectTwo() {
		List<String> result = new WordSearchII().findWords(new char[][] { { 'o', 'a', 'a', 'n' },
				{ 'e', 't', 'a', 'e' }, { 'i', 'h', 'k', 'r' }, { 'i', 'f', 'l', 'v' } },
				new String[] { "oath", "pea", "eat", "rain" });
		assertNotNull(result);
		assertEquals(2, result.size());
		assertTrue(result.contains("eat"));
		assertTrue(result.contains("oath"));
	}

	@Test
	void testFindWordsExpectNone() {
		List<String> result = new WordSearchII().findWords(new char[][] { { 'a', 'b' }, { 'c', 'd' } },
				new String[] { "abcd" });
		assertNotNull(result);
		assertTrue(result.isEmpty());
	}

}
