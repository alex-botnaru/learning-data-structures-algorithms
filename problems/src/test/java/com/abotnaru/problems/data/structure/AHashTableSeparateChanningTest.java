package com.abotnaru.problems.data.structure;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class AHashTableSeparateChanningTest {

	@Test
	void testInsertOneAndSizeIsOne() {
		AHashTableSeparateChanning<Integer, String> hashTable = new AHashTableSeparateChanning<>();
		assertEquals(0, hashTable.size());
		hashTable.insert(1, "One");
		assertEquals(1, hashTable.size());
	}

	@Test
	void testInsertNullKeyWithValueAndExpectException() {
		AHashTableSeparateChanning<Integer, String> hashTable = new AHashTableSeparateChanning<>();
		assertThrows(IllegalArgumentException.class, () -> hashTable.insert(null, "One"));
	}

	@Test
	void testInsertKeyWithNullValueAndExpectException() {
		AHashTableSeparateChanning<Integer, String> hashTable = new AHashTableSeparateChanning<>();
		assertThrows(IllegalArgumentException.class, () -> hashTable.insert(1, null));
	}

	@Test
	void testInsertNullKeyWithNullValueAndExpectException() {
		AHashTableSeparateChanning<Integer, String> hashTable = new AHashTableSeparateChanning<>();
		assertThrows(IllegalArgumentException.class, () -> hashTable.insert(null, null));
	}

	@Test
	void testInsertSameKeyTwiceExpectValueOverrite() {
		AHashTableSeparateChanning<Integer, String> hashTable = new AHashTableSeparateChanning<>();
		assertNull(hashTable.insert(1, "One"));
		assertEquals(1, hashTable.size());
		assertEquals("One", hashTable.insert(1, "Uno"));
		assertEquals(1, hashTable.size());
	}

	@Test
	void testInsertKeyValuesAndGetValues() {
		AHashTableSeparateChanning<Integer, String> hashTable = new AHashTableSeparateChanning<>();
		assertNull(hashTable.insert(1, "One"));
		assertNull(hashTable.insert(2, "Two"));
		assertNull(hashTable.insert(3, "Three"));
		assertEquals(3, hashTable.size());
		assertEquals("One", hashTable.get(1));
		assertEquals("Two", hashTable.get(2));
		assertEquals("Three", hashTable.get(3));
		assertNull(hashTable.get(4));
	}

	@Test
	void testInsertKeyValueAndGetNullExpectException() {
		AHashTableQuadraticProbing<Integer, String> hashTable = new AHashTableQuadraticProbing<>();
		assertNull(hashTable.insert(1, "One"));
		assertThrows(IllegalArgumentException.class, () -> hashTable.get(null));
	}

	@Test
	void testHashMapResizesWhenMoreItemsAdded() {
		AHashTableSeparateChanning<Integer, String> hashTable = new AHashTableSeparateChanning<>();
		assertNull(hashTable.insert(0, "Zero"));
		assertNull(hashTable.insert(1, "One"));
		assertNull(hashTable.insert(2, "Two"));
		assertNull(hashTable.insert(3, "Three"));
		assertNull(hashTable.insert(4, "Four"));
		assertNull(hashTable.insert(5, "Five"));
		assertNull(hashTable.insert(6, "Six"));
		assertNull(hashTable.insert(7, "Seven"));
		assertNull(hashTable.insert(8, "Eight"));
		assertNull(hashTable.insert(9, "Nine"));
		assertEquals(10, hashTable.size());
	}

	@Test
	void testInsertTenValuesAndRemoveFive() {
		AHashTableSeparateChanning<Integer, String> hashTable = new AHashTableSeparateChanning<>();
		assertNull(hashTable.insert(0, "Zero"));
		assertNull(hashTable.insert(1, "One"));
		assertNull(hashTable.insert(2, "Two"));
		assertNull(hashTable.insert(3, "Three"));
		assertNull(hashTable.insert(4, "Four"));
		assertNull(hashTable.insert(5, "Five"));
		assertNull(hashTable.insert(6, "Six"));
		assertNull(hashTable.insert(7, "Seven"));
		assertNull(hashTable.insert(8, "Eight"));
		assertNull(hashTable.insert(9, "Nine"));
		assertEquals(10, hashTable.size());
		assertEquals("One", hashTable.remove(1));
		assertEquals("Three", hashTable.remove(3));
		assertEquals("Five", hashTable.remove(5));
		assertEquals("Seven", hashTable.remove(7));
		assertEquals("Nine", hashTable.remove(9));
		assertNull(hashTable.remove(9));
		assertNull(hashTable.remove(10));
		assertEquals(5, hashTable.size());
	}

	@Test
	void testInsertAndRemoveWithNullKeyExpectException() {
		AHashTableQuadraticProbing<Integer, String> hashTable = new AHashTableQuadraticProbing<>();
		assertNull(hashTable.insert(1, "One"));
		assertThrows(IllegalArgumentException.class, () -> hashTable.remove(null));
	}
}
