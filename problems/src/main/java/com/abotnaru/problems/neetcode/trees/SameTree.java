package com.abotnaru.problems.neetcode.trees;

public class SameTree {

	/**
	 * Returns true if two binary trees are the same, false otherwise.
	 * 
	 * @param node1
	 * @param node2
	 * @return
	 */
	boolean isSameTree(TreeNode node1, TreeNode node2) {

		if (node1 == null && node2 == null) {
			// If both nodes are null, consider they are the same
			return true;
		}

		if (node1 == null || node2 == null) {
			// If only one of the node is null, then they are not the same
			return false;
		}

		// Value should be the same, and left and right subtree should be the same
		return node1.val == node2.val && isSameTree(node1.left, node2.left) && isSameTree(node1.right, node2.right);
	}
}
