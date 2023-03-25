package com.abotnaru.problems.neetcode.backtracking;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;

class CombinationSumIITest {

	@Test
	void testCombinationSum2ExpectFour() {
		List<List<Integer>> result = new CombinationSumII().combinationSum2(new int[] { 10, 1, 2, 7, 6, 1, 5 }, 8);
		assertNotNull(result);
		assertEquals(4, result.size());
	}

	@Test
	void testCombinationSum2ExpectTwo() {
		List<List<Integer>> result = new CombinationSumII().combinationSum2(new int[] { 2, 5, 2, 1, 2 }, 5);
		assertNotNull(result);
		assertEquals(2, result.size());
	}

}
