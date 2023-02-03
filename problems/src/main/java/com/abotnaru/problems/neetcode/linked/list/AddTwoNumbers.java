package com.abotnaru.problems.neetcode.linked.list;

public class AddTwoNumbers {

	/**
	 * Input are non-empty linked lists representing a number in reverse order.
	 * Computes the sum of these two numbers.
	 * <p>
	 * NeedCode solution.
	 * 
	 * @param number1
	 * @param number2
	 * @return
	 */
	public ListNode addTwoNumbers(ListNode number1, ListNode number2) {

		int carry = 0;
		ListNode current1 = number1;
		ListNode current2 = number2;
		ListNode root = new ListNode();
		ListNode tail = root;

		while (current1 != null || current2 != null || carry > 0) {

			int digit1 = current1 != null ? current1.value : 0;
			int digit2 = current2 != null ? current2.value : 0;
			int result = digit1 + digit2 + carry;
			carry = result / 10;
			tail.next = new ListNode(result % 10);
			tail = tail.next;

			if (current1 != null) {
				current1 = current1.next;
			}

			if (current2 != null) {
				current2 = current2.next;
			}

		}

		return root.next;
	}

	/**
	 * Input are non-empty linked lists representing a number in reverse order.
	 * Computes the sum of these two numbers.
	 * <p>
	 * Initial solution.
	 * 
	 * @param number1
	 * @param number2
	 * @return
	 */
	public ListNode addTwoNumbersInitial(ListNode number1, ListNode number2) {

		int carry = 0;
		ListNode current1 = number1;
		ListNode current2 = number2;
		ListNode root = new ListNode();
		ListNode tail = root;

		while (current1 != null && current2 != null) {

			int result = current1.value + current2.value + carry;
			carry = result / 10;
			tail.next = new ListNode(result % 10);
			tail = tail.next;
			current1 = current1.next;
			current2 = current2.next;

		}

		while (current1 != null) {
			int result = current1.value + carry;
			carry = result / 10;
			tail.next = new ListNode(result % 10);
			tail = tail.next;
			current1 = current1.next;
		}

		while (current2 != null) {
			int result = current2.value + carry;
			carry = result / 10;
			tail.next = new ListNode(result % 10);
			tail = tail.next;
			current2 = current2.next;
		}

		if (carry > 0) {
			tail.next = new ListNode(carry);
		}
		return root.next;
	}

}
