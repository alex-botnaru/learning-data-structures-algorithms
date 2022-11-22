package com.abotnaru.problems.neetcode.arrays.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {

	/**
	 * Returns the k most frequent elements.<br>
	 * Space and time complexity O(N), where N is number of elements in the array
	 * 
	 * @param nums
	 * @param k
	 * @return
	 */
	public int[] topKFrequent(int[] nums, int k) {
		List<Integer> result = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();

		// Observation: k cannot be greater than nums.length

		// Frequency "array". The index represents the number of occurrences. The value
		// is a list of numbers at that frequency.
		List<List<Integer>> frequency = new ArrayList<>();

		// Add N empty lists in the frequency list
		for (int i = 0; i < nums.length; i++) {
			frequency.add(new ArrayList<>());
		}

		// Compute the number of occurrences
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		// Populate the numbers for each frequency
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			frequency.get(entry.getValue() - 1).add(entry.getKey());
		}

		// Starting from the end of the frequency array
		for (int i = nums.length - 1; i >= 0; i--) {
			// if at the index the list is empty, then no number with frequency i
			if (!frequency.get(i).isEmpty()) {
				for (Integer num : frequency.get(i)) {
					result.add(num);
					if (result.size() >= k) {
						// make sure only top k frequent elements
						return result.stream().mapToInt(e -> e).toArray();
					}
				}
			}
		}
		return new int[0];
	}
}
