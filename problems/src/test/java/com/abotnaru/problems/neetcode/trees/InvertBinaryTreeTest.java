package com.abotnaru.problems.neetcode.trees;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class InvertBinaryTreeTest {

	@Test
	void testInvertTreeSevenNodes() {
		TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)),
				new TreeNode(7, new TreeNode(6), new TreeNode(9)));
		
		TreeNode actual = new InvertBinaryTree().invertTree(root);
		
		assertNotNull(actual);
		assertEquals(4, actual.val);
		assertEquals(7, actual.left.val );
		assertEquals(9, actual.left.left.val );
		assertEquals(6, actual.left.right.val );
		assertEquals(2, actual.right.val );
		assertEquals(3, actual.right.left.val );
		assertEquals(1, actual.right.right.val );
		
		assertNull(actual.left.left.left);
		assertNull(actual.left.left.right);
		assertNull(actual.left.right.left);
		assertNull(actual.left.right.right);
		
		assertNull(actual.right.left.left);
		assertNull(actual.right.left.right);
		assertNull(actual.right.right.left);
		assertNull(actual.right.right.right);
	}

}
