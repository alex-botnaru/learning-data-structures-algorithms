package com.abotnaru.problems.data.structure;

/**
 * An example of Hash Table implementation using one of the Open Addressing
 * probing method.
 * 
 * @param <K>
 * @param <V>
 */
public class AHashTableQuadraticProbing<K, V> {

	private static final int DEFAULT_CAPACITY = 8;
	private static final double DEFAULT_LOAD_FACTOR = 0.7;

	@SuppressWarnings("unchecked")
	private final K tombStone = (K) (new Object()); // Indicator that a key was previously deleted

	private int capacity = DEFAULT_CAPACITY;
	private double loadFactor = DEFAULT_LOAD_FACTOR;
	private int threshold;
	private int size;

	private K[] keysTable;
	private V[] valuesTable;

	@SuppressWarnings("unchecked")
	public AHashTableQuadraticProbing() {
		threshold = (int) (capacity * loadFactor);
		keysTable = (K[]) new Object[capacity];
		valuesTable = (V[]) new Object[capacity];
	}

	/**
	 * Returns the size of the hash table
	 * 
	 * @return
	 */
	public int size() {
		return size;
	}

	/**
	 * Inserts the key-value pair into hash table. If the key value pair is new,
	 * returns null. If the key already has an associated value, returns the old
	 * value and replaces it with the new value. Null values for the key and value
	 * parameters are not accepted.
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public V insert(K key, V value) {
		if (key == null || value == null) {
			// Do not allow null key or value
			throw new IllegalArgumentException("Key or value cannot be null.");
		}
		checkAndResizeTable();
		V oldValue = null;
		int probeCount = 0;
		int firstProbeIndex = -1;
		int index = (getIndex(key) + probe(probeCount)) % capacity;
		boolean lookingSlot = true;
		do {
			if (keysTable[index] == null) {
				// found an empty slot
				if (firstProbeIndex == -1) {
					keysTable[index] = key;
					valuesTable[index] = value;
				} else {
					keysTable[firstProbeIndex] = key;
					valuesTable[firstProbeIndex] = value;
				}
				size++;
				lookingSlot = false;
			} else if (keysTable[index].equals(key)) {
				// Found an element with the same key
				// Storing the old value to be returned, and replacing it with the new value
				oldValue = valuesTable[index];
				if (firstProbeIndex == -1) {
					valuesTable[index] = value;
				} else {
					keysTable[index] = tombStone;
					valuesTable[index] = null;
					keysTable[firstProbeIndex] = key;
					valuesTable[firstProbeIndex] = value;
				}
				lookingSlot = false;
			} else if (firstProbeIndex == -1 && keysTable[index] == tombStone) {
				// Found first tomb stone, store the index
				firstProbeIndex = index;
			}

			probeCount++;
			index = (getIndex(key) + probe(probeCount)) % capacity;
		} while (lookingSlot);
		return oldValue;
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
	 * Quadratic probing (x^2 + x)/2 function to avoid cycles. The requirement is
	 * that the table size should be power of two.
	 * 
	 * @param x
	 * @return
	 */
	private int probe(int x) {
		return (int) ((Math.pow(x, 2) + x) / 2);
	}

	/**
	 * Helper method that checks if the key and value tables needs to be increased.
	 * If yes, double the size of these tables and reinsert the elements.
	 */
	@SuppressWarnings("unchecked")
	private void checkAndResizeTable() {
		if (size >= threshold) {
			capacity *= 2;
			threshold = (int) (capacity * loadFactor);
			// Store old tables and create new ones with new capacity
			K[] oldKeysTable = keysTable;
			V[] oldValuesTable = valuesTable;
			keysTable = (K[]) new Object[capacity];
			valuesTable = (V[]) new Object[capacity];
			size = 0; // Reset the size because the insert() method is used, which increments the
						// size.
			for (int i = 0; i < oldKeysTable.length; i++) {
				if (oldKeysTable[i] != null && oldKeysTable[i] != tombStone) {
					insert(oldKeysTable[i], oldValuesTable[i]);
				}
				// clean old tables
				oldKeysTable[i] = null;
				oldValuesTable[i] = null;
			}
		}
	}

	/**
	 * Returns the value associated with the provided key. Returns null if no
	 * key-value pair found.
	 * 
	 * @param key
	 * @return
	 */
	public V get(K key) {
		if (key == null) {
			throw new IllegalArgumentException("Key cannot be null");
		}
		int probeCount = 0;
		int index = (getIndex(key) + probe(probeCount)) % capacity;
		while (keysTable[index] != null) {
			// Exit condition, first null key
			if (keysTable[index].equals(key)) {
				// Found the key, break the loop
				break;
			}
			// If not found, keep probing
			probeCount++;
			index = (getIndex(key) + probe(probeCount)) % capacity;
		}

		return valuesTable[index];
	}

	/**
	 * Removes the key-value pair from the table for the specified key, returns the
	 * removed value. Returns null if the specified key doesn't exist.
	 * 
	 * @param key
	 * @return
	 */
	public V remove(K key) {
		if (key == null) {
			throw new IllegalArgumentException("Key cannot be null");
		}
		V result = null;
		int probeCount = 0;
		int index = (getIndex(key) + probe(probeCount)) % capacity;
		while (keysTable[index] != null) {
			if (keysTable[index].equals(key)) {
				// The key was found, store old value, mark the key with tomb stone, remove
				// the value, and decrement the size.
				result = valuesTable[index];
				keysTable[index] = tombStone;
				valuesTable[index] = null;
				size--;
				break;
			}
			// Not found, continue probing
			probeCount++;
			index = (getIndex(key) + probe(probeCount)) % capacity;
		}
		return result;
	}
}
