package com.abotnaru.problems.neetcode.graphs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;

import org.junit.jupiter.api.Test;

class GraphCloneTest {

	@Test
	void testCloneGraph() {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);

		node1.neighbors.add(node2);
		node1.neighbors.add(node4);

		node2.neighbors.add(node1);
		node2.neighbors.add(node3);

		node3.neighbors.add(node2);
		node3.neighbors.add(node4);

		node4.neighbors.add(node1);
		node4.neighbors.add(node3);

		Node copyNode1 = new CloneGraph().cloneGraph(node1);
		assertNotNull(copyNode1);
		assertNotSame(node1, copyNode1);
		assertEquals(node1.val, copyNode1.val);
		assertEquals(node1.neighbors.size(), copyNode1.neighbors.size());
	}
}
