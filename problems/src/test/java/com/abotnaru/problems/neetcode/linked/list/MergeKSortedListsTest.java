package com.abotnaru.problems.neetcode.linked.list;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class MergeKSortedListsTest {

	@Test
	void testMergeKListsNonEmpty() {

		ListNode list1 = new ListNode(1, new ListNode(4, new ListNode(5)));
		ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
		ListNode list3 = new ListNode(2, new ListNode(6));
		ListNode[] input = new ListNode[] { list1, list2, list3 };

		ListNode actual = new MergeKSortedLists().mergeKLists(input);

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
		assertEquals(5, actual.value);
		actual = actual.next;
		assertEquals(6, actual.value);
		assertNull(actual.next);

	}

}
