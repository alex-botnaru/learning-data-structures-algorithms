package com.abotnaru.problems.neetcode.trees;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;

public class BinaryTreeLevelOrderTraversalTest {

	@Test
	void testLevelOrderTraversal() {
		TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));

		List<List<Integer>> actual = new BinaryTreeLevelOrderTraversal().levelOrder(root);

		assertNotNull(actual);
		assertFalse(actual.isEmpty());
		assertEquals(1, actual.get(0).size());
		assertEquals(2, actual.get(1).size());
		assertEquals(2, actual.get(2).size());

		assertEquals(3, actual.get(0).get(0));
		assertEquals(9, actual.get(1).get(0));
		assertEquals(20, actual.get(1).get(1));
		assertEquals(15, actual.get(2).get(0));
		assertEquals(7, actual.get(2).get(1));
	}

}
