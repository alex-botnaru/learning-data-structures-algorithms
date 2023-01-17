package com.abotnaru.problems.neetcode.linked.list;

public class MergeTwoSortedList {

	/**
	 * Merge two sorted linked list into one.
	 * <p>
	 * First implementation is iterative.
	 * 
	 * @param list1
	 * @param list2
	 * @return
	 */
	public ListNode mergeTwoList(ListNode list1, ListNode list2) {
		// return mergeTwoListRecursive(list1, list2);

		// Create a dummy root node, this will avoid for checking additional edge cases,
		// as when one of the lists are empty (null)
		ListNode dummyRoot = new ListNode();
		ListNode tail = dummyRoot; // Additional node to keep track of the tail

		while (list1 != null && list2 != null) {
			if (list1.value < list2.value) {
				// append the node to the end (tail)
				tail.next = list1;
				// Go to next node
				list1 = list1.next;
			} else {
				tail.next = list2;
				list2 = list2.next;
			}
			tail = tail.next; // move the tail one node to the right
		}

		// Attach the remaining list to the tail, one of the list may not be empty
		tail.next = list1 != null ? list1 : list2;

		// Return except the dummy node.
		return dummyRoot.next;

	}

	/**
	 * Merge two sorted linked list into one, recursive approach.
	 * 
	 * @param list1
	 * @param list2
	 * @return
	 */
	public ListNode mergeTwoListRecursive(ListNode list1, ListNode list2) {

		// Base case, when one of the list is null, return the other as the rest of the
		// tail
		if (list1 == null) {
			return list2;
		}
		if (list2 == null) {
			return list1;
		}

		if (list1.value < list2.value) {
			// The current node is the smallest and becomes the head of the right sublist,
			// call recursively the method without current node.
			list1.next = mergeTwoListRecursive(list1.next, list2);
			return list1;

		} else {
			list2.next = mergeTwoListRecursive(list1, list2.next);
			return list2;
		}
	}

}
