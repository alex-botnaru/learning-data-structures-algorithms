package com.abotnaru.problems.neetcode.linked.list;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class CopyListWithRandomPointerTest {

	@Test
	void testCopyRandomListFiveItems() {
		Node node1 = new Node(7);
		Node node2 = new Node(13);
		Node node3 = new Node(11);
		Node node4 = new Node(10);
		Node node5 = new Node(1);

		node1.next = node2;
		node2.next = node3;
		node2.random = node1;
		node3.next = node4;
		node3.random = node5;
		node4.next = node5;
		node4.random = node3;
		node5.random = node1;

		Node newNode1 = new CopyListWithRandomPointer().copyRandomList(node1);
		assertNotNull(newNode1);
		Node newNode2 = newNode1.next;
		assertNotNull(newNode2);
		Node newNode3 = newNode2.next;
		assertNotNull(newNode3);
		Node newNode4 = newNode3.next;
		assertNotNull(newNode4);
		Node newNode5 = newNode4.next;
		assertNotNull(newNode5);
		assertNull(newNode5.next);

		assertNotEquals(node1, newNode1);
		assertNotEquals(node2, newNode2);
		assertNotEquals(node3, newNode3);
		assertNotEquals(node4, newNode4);
		assertNotEquals(node5, newNode5);

		assertEquals(7, newNode1.val);
		assertEquals(13, newNode2.val);
		assertEquals(11, newNode3.val);
		assertEquals(10, newNode4.val);
		assertEquals(1, newNode5.val);

		assertNull(newNode1.random);
		assertEquals(newNode2.random, newNode1);
		assertEquals(newNode3.random, newNode5);
		assertEquals(newNode4.random, newNode3);
		assertEquals(newNode5.random, newNode1);
	}

	@Test
	void testCopyRandomListTwoItems() {
		Node node1 = new Node(1);
		Node node2 = new Node(2);

		node1.next = node2;
		node1.random = node2;
		node2.random = node2;

		Node newNode1 = new CopyListWithRandomPointer().copyRandomList(node1);
		assertNotNull(newNode1);
		Node newNode2 = newNode1.next;
		assertNotNull(newNode2);
		assertNull(newNode2.next);

		assertNotEquals(node1, newNode1);
		assertNotEquals(node2, newNode2);

		assertEquals(1, newNode1.val);
		assertEquals(2, newNode2.val);

		assertEquals(newNode1.random, newNode2);
		assertEquals(newNode2.random, newNode2);
	}

	@Test
	void testCopyRandomListThreeItems() {
		Node node1 = new Node(3);
		Node node2 = new Node(3);
		Node node3 = new Node(3);

		node1.next = node2;
		node2.next = node3;
		node2.random = node1;

		Node newNode1 = new CopyListWithRandomPointer().copyRandomList(node1);
		assertNotNull(newNode1);
		Node newNode2 = newNode1.next;
		assertNotNull(newNode2);
		Node newNode3 = newNode2.next;
		assertNotNull(newNode3);
		assertNull(newNode3.next);

		assertNotEquals(node1, newNode1);
		assertNotEquals(node2, newNode2);
		assertNotEquals(node3, newNode3);

		assertEquals(3, newNode1.val);
		assertEquals(3, newNode2.val);
		assertEquals(3, newNode3.val);

		assertNull(newNode1.random);
		assertEquals(newNode2.random, newNode1);
		assertNull(newNode3.random);
	}

}
