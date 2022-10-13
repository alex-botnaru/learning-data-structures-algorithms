package com.abotnaru.problems.neetcode;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidPalindromeTest {

	@ParameterizedTest
	@ValueSource(strings = { "", "   ", "C", "@2", "Aba", "RaceCar", "A man, a plan, a canal: Panama" })
	void testIsPalindromeTrue(String string) {
		assertTrue(new ValidPalindrome().isPalindrome(string));
	}

	@ParameterizedTest
	@ValueSource(strings = { " 12", "Abc", "RaceACar" })
	void testIsPalindromeFalse(String string) {
		assertFalse(new ValidPalindrome().isPalindrome(string));
	}
}
