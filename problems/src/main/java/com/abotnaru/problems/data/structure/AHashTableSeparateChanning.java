package com.abotnaru.problems.data.structure;

import java.util.LinkedList;
import java.util.List;

/**
 * An example of Hash Table implementation using the Separate Chaining collision
 * resolution method.
 *
 * @param <K> Key type
 * @param <V> Value type
 */
public class AHashTableSeparateChanning<K, V> {

	private static final int DEFAULT_CAPACITY = 5;
	private static final double DEFAULT_LOAD_FACTOR = 0.75;

	private int capacity = DEFAULT_CAPACITY;
	private double loadFactor = DEFAULT_LOAD_FACTOR;
	private int threshold;
	private int size;
	private List<AHashEntry<K, V>>[] table;

	@SuppressWarnings("unchecked")
	public AHashTableSeparateChanning() {
		threshold = (int) (capacity * loadFactor);
		table = new List[capacity];
	}

	/**
	 * Returns the current size of the table.
	 * 
	 * @return
	 */
	public int size() {
		return size;
	}

	/**
	 * Inserts the provided key-value pair into the HashTable. If the key exists,
	 * the value will be overridden.
	 * 
	 * @param key
	 * @param value
	 */
	public void insert(K key, V value) {
		if (key == null || value == null) {
			// Do not allow null key or value
			throw new IllegalArgumentException("Key or value cannot be null.");
		}
		resizeTable();
		int index = getIndex(key);
		if (table[index] == null) {
			// Creates the internal list for the index if doesn't exist
			table[index] = new LinkedList<>();
		}
		AHashEntry<K, V> hashEntry = new AHashEntry<>(key, value);
		boolean keyEntryExist = false;

		for (int i = 0; i < table[index].size(); i++) {
			AHashEntry<K, V> entry = table[index].get(i);
			if (entry.getKey().equals(key)) {
				// Key already exist
				keyEntryExist = true;
				// override the entry with the latest value
				entry.setValue(value);
			}
		}

		if (!keyEntryExist) {
			table[index].add(hashEntry);
			size++;
		}
	}

	/**
	 * Internal method to resize (increase) the internal table
	 */
	private void resizeTable() {
		if (size >= threshold) {
			capacity *= 2; // double the table capacity
			threshold = (int) (capacity * loadFactor); // compute the new threshold
			@SuppressWarnings("unchecked")
			List<AHashEntry<K, V>>[] newTable = new List[capacity];
			for (int i = 0; i < table.length; i++) {
				if (table[i] != null) {
					for (int j = 0; j < table[i].size(); j++) {
						AHashEntry<K, V> entry = table[i].get(j);
						// Recalculate the index in the new table
						int index = getIndex(entry.getKey());
						if (newTable[index] == null) {
							newTable[index] = new LinkedList<>();
						}
						newTable[index].add(entry);
					}

					// Clear up the index
					table[i] = null;
				}
			}
			table = newTable;
		}
	}

	/**
	 * Computes the index for specified key.
	 * 
	 * @param key
	 * @return
	 */
	private int getIndex(K key) {
		return (key.hashCode() & 0x7FFFFFFF) % capacity;
	}

	/**
	 * Searches and returns the value for the specified key. If key is null or not
	 * found, returns null.
	 * 
	 * @param key
	 * @return
	 */
	public V get(K key) {
		V result = null;
		if (key != null) {
			int index = getIndex(key);
			if (table[index] != null) {
				for (int i = 0; i < table[index].size(); i++) {
					AHashEntry<K, V> entry = table[index].get(i);
					if (entry.getKey().equals(key)) {
						result = entry.getValue();
						break;
					}
				}
			}
		}
		return result;
	}

	/**
	 * Removes and returns the value associated with the specified key. Returns
	 * null, if the key is null or doesn't exist.
	 * 
	 * @param key
	 * @return
	 */
	public V remove(K key) {
		V result = null;
		if (key != null) {
			int index = getIndex(key);
			if (table[index] != null) {
				for (int i = 0; i < table[index].size(); i++) {
					AHashEntry<K, V> entry = table[index].get(i);
					if (entry.getKey().equals(key)) {
						// Found the key, store the value, then remove the entry and decrement the size.
						result = entry.getValue();
						table[index].remove(i);
						size--;
						break;
					}
				}
			}
		}
		return result;
	}
}
