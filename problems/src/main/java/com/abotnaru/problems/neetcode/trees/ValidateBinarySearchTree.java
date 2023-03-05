package com.abotnaru.problems.neetcode.trees;

public class ValidateBinarySearchTree {

	/**
	 * Returns if the BST is valid, false otherwise.<br>
	 * The left subtree contains only values that are less than parent node The
	 * right subtree contains only values that are greater than parent node
	 * 
	 * @param root
	 * @return
	 */
	public boolean isValidBST(TreeNode root) {

		if (root == null) {
			return true;
		}

		return dfsHelper(root, null, null);
	}

	/**
	 * Helper function
	 * 
	 * @param node
	 * @param left
	 * @param right
	 * @return
	 */
	private boolean dfsHelper(TreeNode node, Integer left, Integer right) {
		// A null subtree is considered a valid binary search tree tree
		if (node == null) {
			return true;
		}

		// If current node is smaller than the left boundary, OR, greater than the right
		// boundary, we have an invalid tree.
		if ((left != null && node.val <= left) || (right != null && node.val >= right)) {
			return false;
		}

		// 1. For the left subtree, we have to update only the right boundary, all the
		// left children nodes must be less than parent node
		// 2. For the right subtree, we have to update only left boundary, all the right
		// children nodes must be greater than parent node
		return dfsHelper(node.left, left, node.val) && dfsHelper(node.right, node.val, right);
	}
}
