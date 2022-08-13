package com.abotnaru.problems.neetcode;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

	/**
	 * Returns true if any value in the numbers appears at least twice in the array,
	 * and return false if every element is distinct. The time and space complexity
	 * is O(N).
	 * 
	 * @param numbers
	 * @return
	 */
	public boolean containsDuplicate(int[] numbers) {
		Set<Integer> set = new HashSet<>();
		for (int number : numbers) {
			// HashSet add() method return true if the element doesn't exist, false
			// otherwise.
			if (!set.add(number)) {
				return true;
			}
		}
		return false;
	}

}
