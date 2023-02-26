package com.abotnaru.problems.neetcode.trees;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class SameTreeTest {

	@Test
	void testIsSameTreeThreeNodesExpectTrue() {
		TreeNode root1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
		TreeNode root2 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
		assertTrue(new SameTree().isSameTree(root1, root2));
	}

	@Test
	void testIsSameTreeTwoNodesExpectFalse() {
		TreeNode root1 = new TreeNode(1, new TreeNode(2), null);
		TreeNode root2 = new TreeNode(1, null, new TreeNode(2));
		assertFalse(new SameTree().isSameTree(root1, root2));
	}

	@Test
	void testIsSameTreeThreeNodesExpectFalse() {
		TreeNode root1 = new TreeNode(1, new TreeNode(2), new TreeNode(1));
		TreeNode root2 = new TreeNode(1, new TreeNode(1), new TreeNode(2));
		assertFalse(new SameTree().isSameTree(root1, root2));
	}
}
