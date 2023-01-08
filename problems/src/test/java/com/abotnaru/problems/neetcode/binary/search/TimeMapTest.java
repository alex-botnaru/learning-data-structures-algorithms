package com.abotnaru.problems.neetcode.binary.search;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TimeMapTest {

	@Test
	void testSetMethodOneKey() {
		TimeMap timeMap = new TimeMap();
		timeMap.set("key1", "value1", 1);
		timeMap.set("key1", "value2", 3);
		assertEquals(1, timeMap.keysSize());
	}

	@Test
	void testSetOneKeyTwoValuesGetOneValue() {
		TimeMap timeMap = new TimeMap();
		timeMap.set("key1", "value1", 1);
		timeMap.set("key1", "value2", 3);
		assertEquals("value1", timeMap.get("key1", 1));
	}

	@Test
	void testSetOneKeyTwoValuesGetNonExistingKey() {
		TimeMap timeMap = new TimeMap();
		timeMap.set("key1", "value1", 1);
		timeMap.set("key1", "value2", 3);
		assertEquals("", timeMap.get("key2", 1));
	}

	@Test
	void testProblemScenario() {
		TimeMap timeMap = new TimeMap();
		timeMap.set("foo", "bar", 1);
		assertEquals("bar", timeMap.get("foo", 1));
		assertEquals("bar", timeMap.get("foo", 3));
		timeMap.set("foo", "bar2", 4);
		assertEquals("bar2", timeMap.get("foo", 4));
		assertEquals("bar2", timeMap.get("foo", 5));
	}

	@Test
	void testSetTwoKeysGetDifferentTimestamps() {

		TimeMap timeMap = new TimeMap();
		timeMap.set("key1", "value1", 4);
		timeMap.set("key1", "value2", 6);
		timeMap.set("key1", "value3", 9);
		timeMap.set("key2", "value4", 12);
		timeMap.set("key2", "value5", 16);
		assertEquals("", timeMap.get("key1", 1));
		assertEquals("", timeMap.get("key1", 3));
		assertEquals("value1", timeMap.get("key1", 4));
		assertEquals("value1", timeMap.get("key1", 5));

		assertEquals("", timeMap.get("key2", 1));
		assertEquals("", timeMap.get("key2", 10));

	}
}
