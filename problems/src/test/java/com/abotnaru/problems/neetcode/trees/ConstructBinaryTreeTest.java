package com.abotnaru.problems.neetcode.trees;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class ConstructBinaryTreeTest {

	@Test
	void testBuildTree() {
		TreeNode actual = new ConstructBinaryTree().buildTree(new int[] { 3, 9, 20, 15, 7 },
				new int[] { 9, 3, 15, 20, 7 });

		assertNotNull(actual);
		assertEquals(3, actual.val);
		assertEquals(9, actual.left.val);
		assertEquals(20, actual.right.val);
		assertEquals(15, actual.right.left.val);
		assertEquals(7, actual.right.right.val);
	}

}
