package com.abotnaru.problems.neetcode.linked.list;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {

	/**
	 * Creates a copy of the provided linked list.
	 * <p>
	 * This is LeedCode solution.
	 * 
	 * @param node
	 * @return
	 */
	public Node copyRandomList(Node head) {
		Map<Node, Node> mapNode = new HashMap<>();
		Node oldNode = head;
		while (oldNode != null) {
			mapNode.put(oldNode, new Node(oldNode.val));
			oldNode = oldNode.next;
		}

		oldNode = head;
		while (oldNode != null) {
			Node newNode = mapNode.get(oldNode);
			newNode.next = mapNode.get(oldNode.next);
			newNode.random = mapNode.get(oldNode.random);
			oldNode = oldNode.next;
		}
		return mapNode.get(head);
	}

	/**
	 * Creates a copy of the provided linked list.
	 * <p>
	 * This is initial solution.
	 * 
	 * @param node
	 * @return
	 */
	public Node copyRandomListInitial(Node node) {

		Node root = new Node(-1);
		Node tail = root;
		Node oldNode = node;

		Map<Node, Node> mapNode = new HashMap<>();

		while (oldNode != null) {

			tail.next = mapNode.computeIfAbsent(oldNode, k -> new Node(k.val));
			tail = tail.next;

			if (oldNode.random != null) {
				tail.random = mapNode.computeIfAbsent(oldNode.random, k -> new Node(k.val));
			}

			oldNode = oldNode.next;
		}

		return root.next;
	}

}
