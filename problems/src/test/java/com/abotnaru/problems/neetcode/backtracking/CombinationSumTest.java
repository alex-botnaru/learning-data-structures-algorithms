package com.abotnaru.problems.neetcode.backtracking;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;

class CombinationSumTest {

	@Test
	void testCombinatinSumExpectTwoCombinations() {
		List<List<Integer>> result = new CombinationSum().combinationSum(new int[] { 2, 3, 6, 7 }, 7);
		assertNotNull(result);
		assertEquals(2, result.size());
	}

	@Test
	void testCombinatinSumExpectThreeCombinations() {
		List<List<Integer>> result = new CombinationSum().combinationSum(new int[] { 2, 3, 5 }, 8);
		assertNotNull(result);
		assertEquals(3, result.size());
	}

	@Test
	void testCombinatinSumExpectNone() {
		List<List<Integer>> result = new CombinationSum().combinationSum(new int[] { 2 }, 1);
		assertNotNull(result);
		assertEquals(0, result.size());
	}
}
