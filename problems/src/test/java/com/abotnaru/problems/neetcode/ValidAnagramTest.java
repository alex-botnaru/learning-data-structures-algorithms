package com.abotnaru.problems.neetcode;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ValidAnagramTest {

	@Test
	void testBothWordsAreNullFalseAnagram() {
		assertFalse(new ValidAnagram().isValidAnagram(null, null));
	}

	@Test
	void testFirstWordIsNullFalseAnagram() {
		assertFalse(new ValidAnagram().isValidAnagram(null, "test"));
	}

	@Test
	void testSecondWordIsNullFalseAnagram() {
		assertFalse(new ValidAnagram().isValidAnagram(null, "test"));
	}

	@Test
	void testFirstWordLongerThanSecondFalseAnagram() {
		assertFalse(new ValidAnagram().isValidAnagram("abcd", "ab"));
	}

	@Test
	void testSecondWordLongerThanFirstFalseAnagram() {
		assertFalse(new ValidAnagram().isValidAnagram("ab", "abcdef"));
	}

	@Test
	void testAnagramNagaramWordsTrueAnagram() {
		assertTrue(new ValidAnagram().isValidAnagram("anagram", "nagaram"));
	}

	@Test
	void testSecureRescueWordsTrueAnagram() {
		assertTrue(new ValidAnagram().isValidAnagram("Secure", "rescuE"));
	}

	@Test
	void testNonAnagramWordsFalseAnagram() {
		assertFalse(new ValidAnagram().isValidAnagram("rat", "car"));
	}
}
