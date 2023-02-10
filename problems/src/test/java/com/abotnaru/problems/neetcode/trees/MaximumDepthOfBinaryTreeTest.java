package com.abotnaru.problems.neetcode.trees;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MaximumDepthOfBinaryTreeTest {

	@Test
	void testMaxDepth() {
		TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
		
		assertEquals(3, new MaximumDepthOfBinaryTree().maxDepth(root));
	}
}
