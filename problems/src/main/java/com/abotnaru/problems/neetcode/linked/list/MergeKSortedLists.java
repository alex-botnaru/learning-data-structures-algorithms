package com.abotnaru.problems.neetcode.linked.list;

public class MergeKSortedLists {

	/**
	 * Merges an array of sorted linked lists in one linked lists.<br>
	 * Time complexity O(log(k) * n)
	 * 
	 * @param input
	 * @return
	 */
	public ListNode mergeKLists(ListNode[] input) {

		int size = input.length;
		int interval = 1;

		while (interval < size) {
			
			// Merging pair of two lists together
			for (int i = 0; i < size - interval; i += 2 * interval) {
				input[i] = merge(input[i], input[i + interval]);
			}
			// Increase the interval to access the already merged lists
			interval *= 2;
		}

		return size > 0 ? input[0] : null;
	}

	/**
	 * Helper method that merges two sorted linked lists in one.<br>
	 * Assuming both list will have max length N, time complexity will be O(N)
	 * 
	 * @param head1
	 * @param head2
	 * @return
	 */
	private ListNode merge(ListNode head1, ListNode head2) {
		ListNode dummyRoot = new ListNode();
		ListNode tail = dummyRoot;

		while (head1 != null && head2 != null) {
			ListNode node;
			if (head1.value < head2.value) {
				node = head1;
				head1 = head1.next;
			} else {
				node = head2;
				head2 = head2.next;
			}
			tail.next = node;
			tail = tail.next;
		}

		if (head1 != null) {
			tail.next = head1;
		}

		if (head2 != null) {
			tail.next = head2;
		}

		return dummyRoot.next;
	}

	/**
	 * Merges an array of sorted linked lists in one linked lists.<br>
	 * This is the working initial solution
	 * 
	 * @param input
	 * @return
	 */
	public ListNode mergeKListsInit(ListNode[] input) {

		ListNode head = new ListNode();
		ListNode tail = head;

		boolean allListAreEmpty = false;

		while (!allListAreEmpty) {
			int minValue = Integer.MAX_VALUE;
			int minNodeIndex = -1;
			allListAreEmpty = true;

			for (int i = 0; i < input.length; i++) {
				if (input[i] != null) {
					allListAreEmpty = false;
					if (input[i].value < minValue) {
						minValue = input[i].value;
						minNodeIndex = i;
					}
				}
			}

			if (minNodeIndex > -1) {
				ListNode node = input[minNodeIndex];
				input[minNodeIndex] = node.next;
				node.next = null;
				tail.next = node;
				tail = tail.next;
			}
		}

		return head.next;
	}

}
