package com.abotnaru.problems.neetcode.trees;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ValidateBinarySearchTreeTest {

	@Test
	void testValidateBSTAndExpectTrue() {
		TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3));
		assertTrue(new ValidateBinarySearchTree().isValidBST(root));
	}

	@Test
	void testValidateBSTAndExpectFalse() {
		TreeNode root = new TreeNode(5, new TreeNode(1), new TreeNode(4, new TreeNode(3), new TreeNode(6)));
		assertFalse(new ValidateBinarySearchTree().isValidBST(root));
	}
	
	@Test
	void testValidateBSTAndExpectFalseTrickyTree() {
		TreeNode root = new TreeNode(5, new TreeNode(3), new TreeNode(7, new TreeNode(4), new TreeNode(8)));
		assertFalse(new ValidateBinarySearchTree().isValidBST(root));
	}

}
