package com.abotnaru.problems.neetcode.linked.list;

public class ReorderList {

	/**
	 * Reorders the input list in such way that the second half of the list is
	 * reversed and the elements of the second half are inserted between the
	 * elements of the first half.
	 * 
	 * @param input
	 * @return
	 */
	public ListNode reorderList(ListNode input) {

		ListNode slow = input;
		ListNode fast = input.next;

		// 1. Find the middle
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		// Split the list in two, keep track of the middle
		ListNode middle = slow.next;
		slow.next = null;

		// 2. reverse the second half
		ListNode rightList = null;
		while (middle != null) {
			ListNode temp = middle;
			middle = middle.next;
			temp.next = rightList;
			rightList = temp;
		}

		// 3. Merge the arrays
		ListNode leftList = input;
		while (rightList != null) {
			ListNode temp1 = leftList.next;
			ListNode temp2 = rightList.next;
			leftList.next = rightList;
			rightList.next = temp1;

			leftList = temp1;
			rightList = temp2;
		}

		return input;
	}

}
