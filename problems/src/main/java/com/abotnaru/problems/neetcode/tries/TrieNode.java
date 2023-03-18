package com.abotnaru.problems.neetcode.tries;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {

	Map<Character, TrieNode> map = new HashMap<>();
	boolean isWordEnd;
}
