package com.abotnaru.problems.neetcode.linked.list;

public class RemoveNthNodeFromEnd {

	/**
	 * Removes the Nth node from the end of the list and returns the head.
	 * 
	 * @param head
	 * @param nth
	 * @return
	 */
	public ListNode removeNthFromEnd(ListNode head, int nth) {

		if (head == null || head.next == null) {
			// One element, nothing to remove
			return head;
		}

		// Initialize dummy node to count for edge case when nth is equal to the length
		// of the list
		ListNode dummy = new ListNode();
		dummy.next = head;
		ListNode left = dummy;
		ListNode right = dummy;
		// 1. Shift right pointer to nth elements to the right
		for (int i = 0; i < nth; i++) {
			right = right.next;
		}

		// 2. Move both pointers until the right pointer reaches the end.
		// This means that the left pointer will be right before the node that needs to
		// be deleted
		while (right.next != null) {
			left = left.next;
			right = right.next;
		}

		// 3. Remove the node from the list and clean up
		ListNode temp = left.next;
		left.next = temp.next;
		temp.next = null;

		return dummy.next;
	}

}
