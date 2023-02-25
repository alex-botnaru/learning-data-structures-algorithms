package com.abotnaru.problems.neetcode.trees;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class DiamterBinaryTreeTest {

	@Test
	void testDiamterOfBinaryTreeFiveNodes() {
		TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
		assertEquals(3, new DiameterBinaryTree().diameterOfBinaryTree(root));
	}

	@Test
	void testDiamterOfBinaryTreeTwoNodes() {
		TreeNode root = new TreeNode(1, new TreeNode(2), null);
		assertEquals(1, new DiameterBinaryTree().diameterOfBinaryTree(root));
	}

	@Test
	void testDiamterOfBinaryTreeSixNodes() {
		TreeNode root = new TreeNode(1,
				new TreeNode(2, new TreeNode(3, new TreeNode(5), null), new TreeNode(4, new TreeNode(6), null)), null);
		assertEquals(4, new DiameterBinaryTree().diameterOfBinaryTree(root));
	}

}
