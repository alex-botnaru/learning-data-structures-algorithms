package com.abotnaru.problems.neetcode.arrays.hashing;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ContainsDuplicateTest {

	@Test
	void containsNoDuplicatesTest() {
		assertFalse(new ContainsDuplicate().containsDuplicate(new int[] { 1, 2, 3, 4 }));
	}

	@Test
	void contiansOneDuplicateTest() {
		assertTrue(new ContainsDuplicate().containsDuplicate(new int[] { 1, 2, 3, 1 }));
	}

	@Test
	void contiansMultipleDuplicateTest() {
		assertTrue(new ContainsDuplicate().containsDuplicate(new int[] { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 }));
	}
}
