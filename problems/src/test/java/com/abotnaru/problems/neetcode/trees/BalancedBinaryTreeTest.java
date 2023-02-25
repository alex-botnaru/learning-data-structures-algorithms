package com.abotnaru.problems.neetcode.trees;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class BalancedBinaryTreeTest {

	@Test
	void testIsBalancedFiveNodes() {
		TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
		assertTrue(new BalancedBinaryTree().isBalanced(root));
	}

	@Test
	void testIsBalancedSevenNodes() {
		TreeNode root = new TreeNode(1,
				new TreeNode(2, new TreeNode(3, new TreeNode(4), new TreeNode(4)), new TreeNode(3)), new TreeNode(2));
		assertFalse(new BalancedBinaryTree().isBalanced(root));
	}
}
