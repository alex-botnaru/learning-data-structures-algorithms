package com.abotnaru.problems.neetcode.backtracking;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;

class SubsetsTest {

	@Test
	void testSubsetForThreeNumbers() {
		List<List<Integer>> result = new Subsets().subsets(new int[] { 1, 2, 3 });
		assertNotNull(result);
		assertEquals(8, result.size());
	}

	@Test
	void testSubsetForOneNumber() {
		List<List<Integer>> result = new Subsets().subsets(new int[] { 0 });
		assertNotNull(result);
		assertEquals(2, result.size());
	}
}
