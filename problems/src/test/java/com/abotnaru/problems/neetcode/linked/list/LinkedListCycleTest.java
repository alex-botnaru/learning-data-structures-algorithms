package com.abotnaru.problems.neetcode.linked.list;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class LinkedListCycleTest {

	@Test
	void testHasCycleFourItemsList() {
		ListNode node1 = new ListNode(3);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(0);
		ListNode node4 = new ListNode(4);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node2;

		assertTrue(new LinkedListCycle().hasCycle(node1));
	}

	@Test
	void testHasCycleFourItemsListNoCycle() {
		ListNode node1 = new ListNode(3);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(0);
		ListNode node4 = new ListNode(4);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;

		assertFalse(new LinkedListCycle().hasCycle(node1));
	}

	@Test
	void testHasCycleTwoItemsList() {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		node1.next = node2;
		node2.next = node1;

		assertTrue(new LinkedListCycle().hasCycle(node1));
	}

	@Test
	void testHasCycleOneItemList() {
		ListNode node1 = new ListNode(1);
		assertFalse(new LinkedListCycle().hasCycle(node1));
	}

}
