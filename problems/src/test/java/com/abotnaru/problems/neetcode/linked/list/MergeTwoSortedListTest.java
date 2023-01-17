package com.abotnaru.problems.neetcode.linked.list;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class MergeTwoSortedListTest {

	@Test
	void testMergeListsSetOne() {

		ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
		ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));

		ListNode actual = new MergeTwoSortedList().mergeTwoList(list1, list2);
		assertNotNull(actual);
		assertEquals(1, actual.value);
		actual = actual.next;
		assertEquals(1, actual.value);
		actual = actual.next;
		assertEquals(2, actual.value);
		actual = actual.next;
		assertEquals(3, actual.value);
		actual = actual.next;
		assertEquals(4, actual.value);
		actual = actual.next;
		assertEquals(4, actual.value);
		actual = actual.next;
		assertNull(actual);
	}

	@Test
	void testMergeListsBothNull() {
		ListNode actual = new MergeTwoSortedList().mergeTwoList(null, null);
		assertNull(actual);
	}

	@Test
	void testMergeListsOneNull() {
		ListNode actual = new MergeTwoSortedList().mergeTwoList(null, new ListNode(0));
		assertNotNull(actual);
		assertEquals(0, actual.value);
		assertNull(actual.next);
	}
}
