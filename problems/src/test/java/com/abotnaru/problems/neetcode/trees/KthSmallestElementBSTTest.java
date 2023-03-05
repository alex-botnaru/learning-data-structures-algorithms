package com.abotnaru.problems.neetcode.trees;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class KthSmallestElementBSTTest {

	@Test
	void testKthSmallestAndExpectOne() {
		TreeNode root = new TreeNode(3, new TreeNode(1, null, new TreeNode(2)), new TreeNode(4));
		assertEquals(1, new KthSmallestElementBST().kthSmallest(root, 1));
	}

	@Test
	void testKthSmallestAndExpectThree() {
		TreeNode root = new TreeNode(5, new TreeNode(3, new TreeNode(2, new TreeNode(1), null), new TreeNode(4)),
				new TreeNode(6));
		assertEquals(3, new KthSmallestElementBST().kthSmallest(root, 3));
	}

}
