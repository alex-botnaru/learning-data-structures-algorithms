package com.abotnaru.problems.neetcode.trees;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class LcaOfBstTest {

	@Test
	void testLowestCommonAncestorTwoEight() {
		TreeNode root = new TreeNode(6,
				new TreeNode(2, new TreeNode(0), new TreeNode(4, new TreeNode(3), new TreeNode(5))),
				new TreeNode(8, new TreeNode(7), new TreeNode(9)));
		assertEquals(6, new LcaOfBst().lowestCommonAncestor(root, root.left, root.right).val);
	}

	@Test
	void testLowestCommonAncestorTwoFour() {
		TreeNode root = new TreeNode(6,
				new TreeNode(2, new TreeNode(0), new TreeNode(4, new TreeNode(3), new TreeNode(5))),
				new TreeNode(8, new TreeNode(7), new TreeNode(9)));
		assertEquals(2, new LcaOfBst().lowestCommonAncestor(root, root.left, root.left.right).val);
	}
}
