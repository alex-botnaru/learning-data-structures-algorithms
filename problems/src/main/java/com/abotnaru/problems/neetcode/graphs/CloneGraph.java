package com.abotnaru.problems.neetcode.graphs;

import java.util.HashMap;
import java.util.Map;

public class CloneGraph {

	/**
	 * Returns a deep copy of the graph.
	 * 
	 * @param node
	 * @return
	 */
	public Node cloneGraph(Node node) {
		return dfsCopy(node, new HashMap<>());
	}

	/**
	 * Helper recursive function that does DFS and clones the nodes
	 * 
	 * @param node
	 * @param nodesMap
	 * @return
	 */
	private Node dfsCopy(Node node, Map<Node, Node> nodesMap) {
		// If a copy exists, return it immediately
		if (nodesMap.containsKey(node)) {
			return nodesMap.get(node);
		}

		// Else, create a copy, and a copy of its children by calling the same function
		// recursively
		Node copy = new Node(node.val);
		nodesMap.put(node, copy);
		for (Node neighbor : node.neighbors) {
			copy.neighbors.add(dfsCopy(neighbor, nodesMap));
		}
		return copy;
	}
}
