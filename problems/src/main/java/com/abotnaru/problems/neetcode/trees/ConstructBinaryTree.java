package com.abotnaru.problems.neetcode.trees;

import java.util.Arrays;

public class ConstructBinaryTree {

	/**
	 * Build the binary tree from the peorder and inorder traversal values
	 * 
	 * @param preorder
	 * @param inorder
	 * @return
	 */
	public TreeNode buildTree(int[] preorder, int[] inorder) {

		// If no elements, nothing to build
		if (preorder.length == 0 || inorder.length == 0) {
			return null;
		}

		// First element in the preorder array will be always the root
		TreeNode node = new TreeNode(preorder[0]);
		int mid = 0;
		// Find the root in the inorder array, it will divide left and right elements
		for (int i = 0; i < inorder.length; i++) {
			if (preorder[0] == inorder[i]) {
				mid = i;
				break;
			}
		}

		// Recursively build the left and right subtrees
		node.left = buildTree(Arrays.copyOfRange(preorder, 1, mid + 1), Arrays.copyOfRange(inorder, 0, mid));
		node.right = buildTree(Arrays.copyOfRange(preorder, mid + 1, preorder.length),
				Arrays.copyOfRange(inorder, mid + 1, inorder.length));

		return node;
	}

}
