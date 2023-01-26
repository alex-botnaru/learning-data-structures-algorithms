package com.abotnaru.problems.neetcode.linked.list;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class RemoveNthNodeFromEndTest {
	
	@Test
	void testRemoveNthFromEndNthOneAndOne() {
		ListNode input = new ListNode(1);

		ListNode actual = new RemoveNthNodeFromEnd().removeNthFromEnd(input, 1);

		assertNotNull(actual);
		assertEquals(1, actual.value);
		actual = actual.next;
		assertNull(actual);
	}
	
	
	@Test
	void testRemoveNthFromEndNthOne() {
		ListNode input = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

		ListNode actual = new RemoveNthNodeFromEnd().removeNthFromEnd(input, 1);

		assertNotNull(actual);
		assertEquals(1, actual.value);
		actual = actual.next;
		assertEquals(2, actual.value);
		actual = actual.next;
		assertEquals(3, actual.value);
		actual = actual.next;
		assertEquals(4, actual.value);
		actual = actual.next;
		assertNull(actual);
	}

	@Test
	void testRemoveNthFromEndNthTwo() {
		ListNode input = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

		ListNode actual = new RemoveNthNodeFromEnd().removeNthFromEnd(input, 2);

		assertNotNull(actual);
		assertEquals(1, actual.value);
		actual = actual.next;
		assertEquals(2, actual.value);
		actual = actual.next;
		assertEquals(3, actual.value);
		actual = actual.next;
		assertEquals(5, actual.value);
		actual = actual.next;
		assertNull(actual);
	}

	@Test
	void testRemoveNthFromEndNthThree() {
		ListNode input = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

		ListNode actual = new RemoveNthNodeFromEnd().removeNthFromEnd(input, 3);

		assertNotNull(actual);
		assertEquals(1, actual.value);
		actual = actual.next;
		assertEquals(2, actual.value);
		actual = actual.next;
		assertEquals(4, actual.value);
		actual = actual.next;
		assertEquals(5, actual.value);
		actual = actual.next;
		assertNull(actual);
	}

	@Test
	void testRemoveNthFromEndNthFive() {
		ListNode input = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

		ListNode actual = new RemoveNthNodeFromEnd().removeNthFromEnd(input, 5);

		assertNotNull(actual);
		assertEquals(2, actual.value);
		actual = actual.next;
		assertEquals(3, actual.value);
		actual = actual.next;
		assertEquals(4, actual.value);
		actual = actual.next;
		assertEquals(5, actual.value);
		actual = actual.next;
		assertNull(actual);
	}

}
