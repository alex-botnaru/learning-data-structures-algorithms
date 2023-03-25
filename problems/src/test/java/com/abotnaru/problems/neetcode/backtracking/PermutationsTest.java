package com.abotnaru.problems.neetcode.backtracking;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;

class PermutationsTest {

	@Test
	void testPermuteAndGetSixElements() {
		List<List<Integer>> result = new Permutations().permute(new int[] { 1, 2, 3 });
		assertNotNull(result);
		assertEquals(6, result.size());
	}

	@Test
	void testPermuteAndGetTwoElements() {
		List<List<Integer>> result = new Permutations().permute(new int[] { 0, 1 });
		assertNotNull(result);
		assertEquals(2, result.size());
	}

	@Test
	void testPermuteAndGetOneElement() {
		List<List<Integer>> result = new Permutations().permute(new int[] { 1 });
		assertNotNull(result);
		assertEquals(1, result.size());
	}
}
