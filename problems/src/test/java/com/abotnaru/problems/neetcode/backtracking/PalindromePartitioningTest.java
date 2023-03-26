package com.abotnaru.problems.neetcode.backtracking;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;

class PalindromePartitioningTest {

	@Test
	void testPalindromePartitioningExpectTwo() {
		List<List<String>> result = new PalindromePartitioning().partition("aab");
		assertNotNull(result);
		assertEquals(2, result.size());
	}

	@Test
	void testPalindromePartitioningExpectOne() {
		List<List<String>> result = new PalindromePartitioning().partition("a");
		assertNotNull(result);
		assertEquals(1, result.size());
	}
}
