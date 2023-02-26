package com.abotnaru.problems.neetcode.trees;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class SubtreeOfAnotherTreeTest {

	@Test
	void testIsSubTreeAndExpectTrue() {
		TreeNode root = new TreeNode(3, new TreeNode(4, new TreeNode(1), new TreeNode(2)), new TreeNode(5));
		TreeNode subTree = new TreeNode(4, new TreeNode(1), new TreeNode(2));

		assertTrue(new SubtreeOfAnotherTree().isSubtree(root, subTree));
	}

	@Test
	void testIsSubTreeAndExpectFalse() {
		TreeNode root = new TreeNode(3, new TreeNode(4, new TreeNode(1), new TreeNode(2, new TreeNode(0), null)),
				new TreeNode(5));
		TreeNode subTree = new TreeNode(4, new TreeNode(1), new TreeNode(2));

		assertFalse(new SubtreeOfAnotherTree().isSubtree(root, subTree));
	}
}
