package com.abotnaru.problems.neetcode.trees;

public class SubtreeOfAnotherTree {

	/**
	 * Returns true if subTree is a subtree of the root node, false otherwise
	 * 
	 * @param root
	 * @param subTree
	 * @return
	 */
	public boolean isSubtree(TreeNode root, TreeNode subTree) {

		if (root == null && subTree == null) {
			// If both nodes are null, consider they are the same
			return true;
		}

		if (root == null) {
			// subTree cannot be a subtree of a null root, however null subTree can be a
			// subtree of root
			return false;
		}

		// Check if both trees are the same
		if (isSameTree(root, subTree)) {
			return true;
		}

		// Check if one of the child node is a subtree
		return isSubtree(root.left, subTree) || isSubtree(root.right, subTree);
	}

	/**
	 * Returns true if two binary trees are the same, false otherwise.
	 * 
	 * @param node1
	 * @param node2
	 * @return
	 */
	private boolean isSameTree(TreeNode node1, TreeNode node2) {

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
