package com.abotnaru.problems.neetcode.linked.list;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class FindDuplicateNumberTest {
	
	@Test
	void testFindDuplicateTwo() {
		assertEquals(2, new FindDuplicateNumber().findDuplicate(new int[] {1, 3, 4, 2, 2}));
	}
	
	@Test
	void testFindDuplicateThree() {
		assertEquals(3, new FindDuplicateNumber().findDuplicate(new int[] {3, 1, 3, 4, 2}));
	}

}
