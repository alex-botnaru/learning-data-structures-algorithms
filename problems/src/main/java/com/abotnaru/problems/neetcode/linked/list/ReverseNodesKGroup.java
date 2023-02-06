package com.abotnaru.problems.neetcode.linked.list;

public class ReverseNodesKGroup {

	/**
	 * Group the elements in the list by groups of k elements and reorder those
	 * groups.<br>
	 * O(N) time complexity and constant space complexity.
	 * 
	 * @param head
	 * @param k
	 * @return
	 */
	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode dummyRoot = new ListNode(-1, head);
		ListNode prevGroupEnd = dummyRoot;
		ListNode kthNode = null;

		// Use a helper method to get kth element after previous group end node
		while ((kthNode = getKthNode(prevGroupEnd, k)) != null) {
			ListNode current = prevGroupEnd.next; // get the first node of the current group
			ListNode next = kthNode.next; // get the first node of the next group

			// Reverse the current group
			while (current != kthNode) {
				ListNode temp = current; // Temporary store the current node
				current = current.next; // Move the current pointer to the next node in group

				// Current becomes the last
				temp.next = next;
				next = temp;
			}
			current.next = next; // current == kthNode, assign the correct next element

			// Previous group last node still points to the ex-first node in the current
			// group. Temporary store it as it is the last node in the current group.
			ListNode temp = prevGroupEnd.next;
			// Correct the link, last node in the previous group, now points to the kthNode
			// which now is the first node in the current group.
			prevGroupEnd.next = current;
			// The last node in the current group, now becomes the end node of the previous
			// group, moving to the next group
			prevGroupEnd = temp;
		}

		return dummyRoot.next;
	}

	/**
	 * Helper method to get the kth node after provided node
	 * 
	 * @param node
	 * @param k
	 * @return
	 */
	private ListNode getKthNode(ListNode node, int k) {
		ListNode current = node;
		int count = k;
		while (current != null && count > 0) {
			current = current.next;
			count--;
		}
		return current;
	}

}
