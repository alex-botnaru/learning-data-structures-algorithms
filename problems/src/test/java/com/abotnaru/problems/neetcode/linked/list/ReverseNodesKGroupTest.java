package com.abotnaru.problems.neetcode.linked.list;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class ReverseNodesKGroupTest {

	@Test
	void testReverseKGroupTwo() {
		ListNode input = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

		ListNode actual = new ReverseNodesKGroup().reverseKGroup(input, 2);

		assertNotNull(actual);
		assertEquals(2, actual.value);
		actual = actual.next;
		assertEquals(1, actual.value);
		actual = actual.next;
		assertEquals(4, actual.value);
		actual = actual.next;
		assertEquals(3, actual.value);
		actual = actual.next;
		assertEquals(5, actual.value);
		assertNull(actual.next);
	}

	@Test
	void testReverseKGroupThree() {
		ListNode input = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

		ListNode actual = new ReverseNodesKGroup().reverseKGroup(input, 3);

		assertNotNull(actual);
		assertEquals(3, actual.value);
		actual = actual.next;
		assertEquals(2, actual.value);
		actual = actual.next;
		assertEquals(1, actual.value);
		actual = actual.next;
		assertEquals(4, actual.value);
		actual = actual.next;
		assertEquals(5, actual.value);
		assertNull(actual.next);
	}

	@Test
	void testReverseKGroupFour() {
		ListNode input = new ListNode(1, new ListNode(2, new ListNode(3)));

		ListNode actual = new ReverseNodesKGroup().reverseKGroup(input, 4);

		assertNotNull(actual);
		assertEquals(1, actual.value);
		actual = actual.next;
		assertEquals(2, actual.value);
		actual = actual.next;
		assertEquals(3, actual.value);
		assertNull(actual.next);
	}

	@Test
	void testReverseKGroupThreeAndThree() {
		ListNode input = new ListNode(1, new ListNode(2, new ListNode(3)));

		ListNode actual = new ReverseNodesKGroup().reverseKGroup(input, 3);

		assertNotNull(actual);
		assertEquals(3, actual.value);
		actual = actual.next;
		assertEquals(2, actual.value);
		actual = actual.next;
		assertEquals(1, actual.value);
		assertNull(actual.next);
	}
}
