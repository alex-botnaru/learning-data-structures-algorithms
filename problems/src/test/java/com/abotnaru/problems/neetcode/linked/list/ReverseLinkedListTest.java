package com.abotnaru.problems.neetcode.linked.list;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class ReverseLinkedListTest {

	@Test
	void testReverseList() {

		ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
		ListNode actual = new ReverseLinkedList().reverseList(head);
		assertNotNull(actual);
		assertEquals(5, actual.value);
		actual = actual.next;
		assertEquals(4, actual.value);
		actual = actual.next;
		assertEquals(3, actual.value);
		actual = actual.next;
		assertEquals(2, actual.value);
		actual = actual.next;
		assertEquals(1, actual.value);
		actual = actual.next;
		assertNull(actual);
	}

}
