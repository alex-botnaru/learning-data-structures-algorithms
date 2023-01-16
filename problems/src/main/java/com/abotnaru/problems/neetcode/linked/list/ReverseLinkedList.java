package com.abotnaru.problems.neetcode.linked.list;

public class ReverseLinkedList {

	/**
	 * For the given single linked list, reverts the list and returns the head of
	 * the linked list. Time complexity O(N), constant space.
	 * 
	 * @param head
	 * @return
	 */
	public ListNode reverseList(ListNode head) {
		// return reverseRecursive(head, null);
		ListNode reversedHead = null;
		ListNode temp = null;
		ListNode current = head;

		while (current != null) {
			temp = current; // Temporarily store the current node
			current = current.next; // next node becomes current
			temp.next = reversedHead; // temp node points to the head of existing reversed list
			reversedHead = temp; // update the head of the existing reversed list
		}

		return reversedHead;
	}

	/**
	 * Recursive solution for the above code. Time and space complexity O(N).
	 * 
	 * @param node
	 * @param previous - is the head of the reversed list
	 * @return
	 */
	public ListNode reverseRecursive(ListNode node, ListNode previous) {
		if (node == null)
			return previous;
		ListNode temp = node.next; // next node becomes the current
		node.next = previous; // current node becomes the head of the reversed list
		return reverseRecursive(temp, node);
	}

}
