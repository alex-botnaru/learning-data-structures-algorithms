package com.abotnaru.problems.neetcode.linked.list;

public class LinkedListCycle {

	/**
	 * Returns true if the Linked List has a cycle in it. False otherwise.
	 * <p>
	 * Constant space complexity and linear time complexity.
	 * 
	 * @param head
	 * @return
	 */
	public boolean hasCycle(ListNode head) {

		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {

			slow = slow.next;
			fast = fast.next.next;

			if (fast == slow) {
				return true;
			}

		}
		return false;
	}

}
