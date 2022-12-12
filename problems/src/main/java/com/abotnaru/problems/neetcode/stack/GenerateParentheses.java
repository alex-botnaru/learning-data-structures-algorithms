package com.abotnaru.problems.neetcode.stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class GenerateParentheses {

	private Stack<Character> stack = new Stack<>();
	private int input;

	/**
	 * Generates all combinations of well-formed parentheses for a given number
	 * 
	 * @param input
	 * @return
	 */
	public List<String> generateParenthesis(int input) {
		this.input = input;
		List<String> result = new ArrayList<>();
		generateCombinations(0, 0, result);
		return result;
	}

	/**
	 * Recursive function that generates all possible combinations
	 * 
	 * @param opened
	 * @param closed
	 * @param resultStore
	 */
	private void generateCombinations(int opened, int closed, List<String> resultStore) {

		// 1. When number of open and closed parentheses matches, then we have a valid
		// combination. Add it to the list.
		if (opened == input && closed == input) {
			StringBuilder builder = new StringBuilder();
			for (char ch : stack) {
				builder.append(ch);
			}
			if (builder.length() > 0) {
				resultStore.add(builder.toString());
			}
		}

		// 2. We can still add an open parenthesis if we haven't reach the limit
		if (opened < input) {
			stack.push('(');
			generateCombinations(opened + 1, closed, resultStore);
			stack.pop();
		}

		// 3. We can only add a close parenthesis only if we have enough opened
		// parentheses
		if (closed < opened) {
			stack.push(')');
			generateCombinations(opened, closed + 1, resultStore);
			stack.pop();
		}
	}

	/**
	 * Below is initial, NOT WORKING implementation.<br>
	 * It generates less combinations for input > 3, doesn't use stack and is less
	 * efficient, for both time and space complexity.<br>
	 * The solution is recursive but can be implemented as iterative.
	 * 
	 * @param input
	 * @return
	 */
	public List<String> generateParenthesisInitial(int input) {
		Map<Integer, Set<String>> map = new HashMap<>();
		map.put(0, Set.of());
		map.put(1, Set.of("()"));

		Set<String> set = getCombinationsFor(input, map);

		return List.copyOf(set);
	}

	private Set<String> getCombinationsFor(int input, Map<Integer, Set<String>> map) {
		if (!map.containsKey(input)) {
			Set<String> prevSet = getCombinationsFor(input - 1, map);
			Set<String> newSet = new HashSet<>();
			for (String combination : prevSet) {
				newSet.add("()" + combination);
				newSet.add("(" + combination + ")");
				newSet.add(combination + "()");
			}
			map.put(input, newSet);
		}
		return map.get(input);
	}

}
