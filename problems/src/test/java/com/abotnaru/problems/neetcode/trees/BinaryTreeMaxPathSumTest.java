package com.abotnaru.problems.neetcode.trees;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class BinaryTreeMaxPathSumTest {

	@Test
	void testMaxPathSumExpectSix() {
		TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
		assertEquals(6, new BinaryTreeMaxPathSum().maxPathSum(root));
	}

	@Test
	void testMaxPathSumExpectFortyTwo() {
		TreeNode root = new TreeNode(-10, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
		assertEquals(42, new BinaryTreeMaxPathSum().maxPathSum(root));
	}
}
