package com.abotnaru.problems.neetcode.backtracking;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;

class SubsetsIITest {

	@Test
	void testSubsetsWithDupsAndExpectSix() {
		List<List<Integer>> result = new SubsetsII().subsetsWithDup(new int[] { 1, 2, 2 });
		assertNotNull(result);
		assertEquals(6, result.size());
	}

	@Test
	void testSubsetsWithDupsAndExpectTwo() {
		List<List<Integer>> result = new SubsetsII().subsetsWithDup(new int[] { 0 });
		assertNotNull(result);
		assertEquals(2, result.size());
	}

}
