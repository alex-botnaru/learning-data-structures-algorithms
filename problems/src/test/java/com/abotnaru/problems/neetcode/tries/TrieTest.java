package com.abotnaru.problems.neetcode.tries;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class TrieTest {

	@Test
	void testTrie() {
		Trie trie = new Trie();
		trie.insert("apple");
		assertTrue(trie.search("apple"));
		assertFalse(trie.search("app"));
		assertTrue(trie.startsWith("app"));
		trie.insert("app");
		assertTrue(trie.search("app"));

	}
}
