package com.abotnaru.problems.neetcode.linked.list;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

	private int capacity;
	private Map<Integer, ListDoubleNode> cache = new HashMap<>();

	// Initiate dummy pointers just to keep track of most recent and least recent
	// used nodes.
	// This also saves us logic from checking edge cases when the list is empty or
	// has few elements. These are not stored in cache
	private ListDoubleNode mostRecentPointer = new ListDoubleNode(-1, -1);
	private ListDoubleNode leastRecentPointer = new ListDoubleNode(-1, -1);

	public LRUCache(int capacity) {
		this.capacity = capacity;
		mostRecentPointer.prev = leastRecentPointer;
		leastRecentPointer.next = mostRecentPointer;
	}

	public void put(int key, int value) {
		if (cache.containsKey(key)) {
			// Remove the current node if exist
			removeNode(cache.get(key));
		}

		// Create new node and insert it a the beginning of the list.
		ListDoubleNode node = new ListDoubleNode(key, value);
		cache.put(key, node);
		insertNode(node);

		if (cache.size() > capacity) {
			// When capacity is exceeded, remove the last element from the list
			ListDoubleNode lru = leastRecentPointer.next;
			removeNode(lru);
			cache.remove(lru.key);
		}
	}

	public int get(int key) {
		if (cache.containsKey(key)) {
			// Remove the node from the list and re-insert again at the beginning
			ListDoubleNode node = cache.get(key);
			removeNode(node);
			insertNode(node);
			return cache.get(key).value;
		}
		return -1;
	}

	/**
	 * Helper method that removes a node from the double linked list
	 * 
	 * @param node
	 */
	private void removeNode(ListDoubleNode node) {
		ListDoubleNode prev = node.prev;
		ListDoubleNode next = node.next;

		prev.next = next;
		next.prev = prev;

		node.prev = null;
		node.next = null;
	}

	/**
	 * Helper function to insert the node before most recent pointer node
	 * 
	 * @param node
	 */
	private void insertNode(ListDoubleNode node) {
		ListDoubleNode previous = mostRecentPointer.prev;

		previous.next = node;
		mostRecentPointer.prev = node;

		node.prev = previous;
		node.next = mostRecentPointer;

	}

}
