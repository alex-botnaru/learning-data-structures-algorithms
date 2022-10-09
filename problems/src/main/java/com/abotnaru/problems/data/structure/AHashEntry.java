package com.abotnaru.problems.data.structure;

public class AHashEntry<K, V> {
	private K key;
	private V value;
	private int hash;

	public AHashEntry(K key, V value) {
		this.key = key;
		this.value = value;
		hash = key.hashCode();
	}

	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (other == null || getClass() != other.getClass()) {
			return false;
		}
		@SuppressWarnings("unchecked")
		AHashEntry<K, V> otherHash = (AHashEntry<K, V>) other;
		boolean isEqual = hash == otherHash.hash;
		if (!isEqual)
			isEqual = key.equals(otherHash.key);
		return isEqual;
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public String toString() {
		return key + " => " + value;
	}
}
