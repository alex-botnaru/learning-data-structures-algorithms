package com.abotnaru.problems.neetcode.trees;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CountGoodNodesInBinaryTreeTest {

	@Test
	void testCountGoodNodesAndExpectFour() {
		TreeNode root = new TreeNode(3, new TreeNode(1, new TreeNode(3), null),
				new TreeNode(4, new TreeNode(1), new TreeNode(5)));

		assertEquals(4, new CountGoodNodesInBinaryTree().goodNodes(root));
	}

	@Test
	void testCountGoodNodesAndExpectThree() {
		TreeNode root = new TreeNode(3, new TreeNode(3, new TreeNode(4), new TreeNode(2)), null);

		assertEquals(3, new CountGoodNodesInBinaryTree().goodNodes(root));
	}

}
