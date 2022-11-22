package com.abotnaru.problems.neetcode.arrays.hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestConsecutiveSequence {

	/**
	 * For giving an unsorted array of integers, the method returns the length of
	 * the longest consecutive elements sequence.
	 * <p>
	 * This is optimized solution from the leetcode.com. Time and space complexity
	 * is O(N)
	 * <p>
	 * a. Store all the numbers of the input array in a Set<br>
	 * b. If the number doesn't have the left neighbor, then it is a start of the
	 * sequence. Iterate to the right and increment the sequence length.<br>
	 * NOTE: If the number is not the start of the sequence (a left element exist)
	 * then the inner loop will be skipped.
	 * 
	 * @param input
	 * @return
	 */
	public int longestConsecutive(int[] input) {
		Set<Integer> numberSet = new HashSet<>();
		int longestSequence = 1;
		for (int number : input) {
			numberSet.add(number);
		}
		for (int number : input) {
			if (!numberSet.contains(number - 1)) {
				// no left neighbor, it is start of the sequence
				int currentNumber = number;
				int currentSequence = 1;
				while (numberSet.contains(currentNumber + 1)) {
					currentNumber++;
					currentSequence++;
				}
				longestSequence = Math.max(longestSequence, currentSequence);
			}
		}
		return longestSequence;
	}

	/**
	 * For giving an unsorted array of integers, the method returns the length of
	 * the longest consecutive elements sequence.
	 * <p>
	 * 1. The brute force approach will be to sort the array, which is O(N logN),
	 * then loop through the array and count the sequence length. When a sequence
	 * ends, update the max length.<br>
	 * Overall complexity of this is O(N logN)
	 * <p>
	 * 2. My O(N) approach, has two loops.<br>
	 * a. First loop adds all elements to a map, where key is the number, and the
	 * value is one and represents the sequence length.<br>
	 * b. For each number in the array, check recursively if the number - 1 exist in
	 * the map<br>
	 * If exists, add its sequence value to the sequence of the current number, set
	 * sequence length to null for the next number to not check it again.
	 * 
	 * @param input
	 * @return
	 */
	public int longestConsecutiveInitial(int[] input) {
		Map<Integer, Integer> numbersMap = new HashMap<>();
		int longestSequence = 1;
		for (int number : input) {
			numbersMap.put(number, 1);
		}
		for (int number : input) {
			int sequence = getConsecutiveSequence(number, numbersMap);
			longestSequence = Math.max(longestSequence, sequence);
		}
		return longestSequence;
	}

	/**
	 * Recursively iterates through the map to find the sequence
	 * 
	 * @param key
	 * @param numbersMap
	 * @return
	 */
	private static int getConsecutiveSequence(int key, Map<Integer, Integer> numbersMap) {
		// Stop condition when the value is null
		if (numbersMap.get(key) == null)
			return 0;
		int nextKey = key - 1;
		int value = 0;
		if (!numbersMap.containsKey(nextKey)) {
			// If there is no sequence in the number, return current value
			value = numbersMap.get(key);
		} else {
			value = numbersMap.get(key);
			// recursively call itself to get the next number in the sequence
			value += getConsecutiveSequence(nextKey, numbersMap);
			numbersMap.put(key, value); // Update the sequence length
			numbersMap.put(nextKey, null); // Set the sequence length to null so we don't check again.
		}

		return value;
	}

}
