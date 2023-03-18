package com.abotnaru.problems.neetcode.tries;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {

	Map<Character, TrieNode> children = new HashMap<>();
	boolean isWordEnd;
}
