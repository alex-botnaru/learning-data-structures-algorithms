package com.abotnaru.problems.neetcode.binary.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeMap {

	private static class TimeValues {
		List<Integer> timestamps = new ArrayList<>();
		List<String> values = new ArrayList<>();
	}

	private Map<String, TimeValues> map = new HashMap<>();

	public void set(String key, String value, int timestamp) {
		map.computeIfAbsent(key, k -> new TimeValues());
		map.get(key).timestamps.add(timestamp);
		map.get(key).values.add(value);
	}

	public String get(String key, int timestamp) {
		String result = "";
		TimeValues timeValues = map.get(key);
		if (timeValues != null) {
			int valueIndex = timestampBinarySearch(timeValues.timestamps, timestamp);
			if (valueIndex > -1) {
				result = timeValues.values.get(valueIndex);
			}
		}
		return result;
	}

	public int keysSize() {
		return map.size();
	}

	private static int timestampBinarySearch(List<Integer> list, int timestamp) {
		int left = 0;
		int right = list.size() - 1;
		while (left <= right) {
			int middle = (left + right) / 2;
			if (list.get(middle) == timestamp || (left == right && list.get(right) < timestamp)) {
				return middle;
			} else if (list.get(middle) < timestamp) {
				left = middle + 1;
			} else {
				right = middle - 1;
			}
		}
		return -1;
	}

}
