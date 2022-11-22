package com.abotnaru.problems.neetcode.arrays.hashing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

class GroupAnagramsTest {

	@Test
	void testArrayWithOneEmptyString() {
		List<List<String>> anagramGroups = new GroupAnagrams().groupAnagrams(new String[] { "" });
		assertEquals(1, anagramGroups.size());
		assertEquals(1, anagramGroups.get(0).size());
		assertEquals("", anagramGroups.get(0).get(0));
	}

	@Test
	void testArrayWithOneCharString() {
		List<List<String>> anagramGroups = new GroupAnagrams().groupAnagrams(new String[] { "a" });
		assertEquals(1, anagramGroups.size());
		assertEquals(1, anagramGroups.get(0).size());
		assertEquals("a", anagramGroups.get(0).get(0));
	}

	@Test
	void testArrayWithOneGroupAnagramTwoWords() {
		String[] strs = new String[] { "ab", "ba" };
		List<List<String>> anagramGroups = new GroupAnagrams().groupAnagrams(strs);
		assertEquals(1, anagramGroups.size());
		assertEquals(2, anagramGroups.get(0).size());
		assertTrue(anagramGroups.get(0).contains(strs[0]));
		assertTrue(anagramGroups.get(0).contains(strs[1]));
	}

	@Test
	void testArrayWithTwoGroupAnagramTwoWordsEach() {
		String[] strs = new String[] { "ab", "ba", "abc", "bca" };
		List<List<String>> anagramGroups = new GroupAnagrams().groupAnagrams(strs);
		assertEquals(2, anagramGroups.size());
		assertEquals(2, anagramGroups.get(0).size());
		assertEquals(2, anagramGroups.get(1).size());
	}

	@Test
	void testArrayWithThreeGroupAnagram() {
		String[] strs = new String[] { "eat", "tea", "tan", "ate", "nat", "bat" };
		List<List<String>> anagramGroups = new GroupAnagrams().groupAnagrams(strs);
		assertEquals(3, anagramGroups.size());

		for (List<String> group : anagramGroups) {
			if (group.size() == 1) {
				assertEquals("bat", group.get(0));
			} else if (group.size() == 2) {
				assertTrue(group.contains(strs[2]));
				assertTrue(group.contains(strs[4]));
			} else {
				assertTrue(group.contains(strs[0]));
				assertTrue(group.contains(strs[1]));
				assertTrue(group.contains(strs[3]));
			}
		}
	}
	
	@Test
	void testArrayWithTwoGroupAnagramRepeatedLetters() {
		String[] strs = new String[] { "bee", "aartar", "ararat", "tarara", "ebe" };
		List<List<String>> anagramGroups = new GroupAnagrams().groupAnagrams(strs);
		assertEquals(2, anagramGroups.size());

		for (List<String> group : anagramGroups) {
			if (group.size() == 2) {
				assertTrue(group.contains(strs[0]));
				assertTrue(group.contains(strs[4]));
			} else {
				assertTrue(group.contains(strs[1]));
				assertTrue(group.contains(strs[2]));
				assertTrue(group.contains(strs[3]));
			}
		}
	}
}
