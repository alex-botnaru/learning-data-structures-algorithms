package com.abotnaru.problems.neetcode.backtracking;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;

class LetterPhoneNumberCombinationsTest {

	@Test
	void testLetterCombinationsExpectNine() {
		List<String> result = new LetterPhoneNumberCombinations().letterCombinations("23");
		assertNotNull(result);
		assertEquals(9, result.size());
	}

	@Test
	void testLetterCombinationsExpectNone() {
		List<String> result = new LetterPhoneNumberCombinations().letterCombinations("");
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	@Test
	void testLetterCombinationsExpectThree() {
		List<String> result = new LetterPhoneNumberCombinations().letterCombinations("2");
		assertNotNull(result);
		assertEquals(3, result.size());
	}

}
