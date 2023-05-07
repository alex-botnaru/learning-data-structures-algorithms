package com.abotnaru.problems.neetcode.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {

	/**
	 * Returns the list of sizes of partitions that contains unique characters
	 * 
	 * @param s
	 * @return
	 */
	public List<Integer> partitionLabels(String s) {
		Map<Character, Integer> lastPosMap = new HashMap<>();
		List<Integer> result = new ArrayList<>();

		// Populate the map with the index of last occurrence of the character
		for (int i = 0; i < s.length(); i++) {
			lastPosMap.put(s.charAt(i), i);
		}

		int size = 0;
		int end = 0;
		for (int i = 0; i < s.length(); i++) {
			// for each character, increment the size, and update the end of partition
			size++;
			end = Math.max(end, lastPosMap.get(s.charAt(i)));

			if (i == end) {
				// we reached the end of the partition, add the size to result and reset it
				result.add(size);
				size = 0;
			}
		}

		return result;
	}
}
